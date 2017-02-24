package ua.google.team.hashcode.io;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

import ua.google.team.hashcode.commons.Data;
import ua.google.team.hashcode.model.Endpoint;
import ua.google.team.hashcode.model.Server;
import ua.google.team.hashcode.model.Video;

public class DataReader {

	public static final Pattern DATA_SEPARATOR = Pattern.compile(" ");
	static int videosCount, endPointsCount, requestDescriptionsCount, cachesCount, cacheSize;
	static String test;

	public static void main(String[] args) throws IOException {
		DataReader parser = new DataReader();
		String fileName = "me_at_the_zoo.in";
		String fullPath = parser.getClass().getClassLoader().getResource(fileName).getPath();
		Data data = parser.readDataFromFile(fullPath);

		System.out.println(data.getVideos());
		System.out.println(data.getServers());
		System.out.println(data.getEndpoints());
	}

	public Data readDataFromFile(String fileName) {
		Data data = new Data();
		Path path = Paths.get(fileName);

		List<long[]> lines = null;
		try {
			lines = Files
					.lines(path)
					.map(DATA_SEPARATOR::splitAsStream)
					.map(s -> s.mapToLong(Long::parseLong).toArray())
					.collect(toList());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		int cursor = 0;

		long[] mainData = lines.get(cursor++);
		long videoCount = mainData[0];
		long endpointCount = mainData[1];
//		long reqDescCount = mainData[2];
		long serverCount = mainData[3];
		long serverSize = mainData[4];

		//Initialize servers
		LongStream.range(0, serverCount)
				  .mapToObj(id -> new Server(id, serverSize))
				  .forEach(data::addServer);

		//Initialize videos and put on Data Center
		long[] videoSizes = lines.get(cursor++);
		LongStream.range(0, videoCount)
				  .mapToObj(id -> new Video(id, videoSizes[(int) id]))
				  .forEach(data::addVideo);


		//Initialize endpoints
		for (int i = 0; i < endpointCount; i++) {
			long[] endpointData = lines.get(cursor++);
			long globalLatency = endpointData[0];
			Endpoint endpoint = new Endpoint(i, globalLatency);
			data.addEndpoint(endpoint);

			//fill up endpoint 2 server connections
			long endpointServersCount = endpointData[1];
			int endOfBlock = (int) (cursor + endpointServersCount);
			for (; cursor < endOfBlock; cursor++) {
				long[] connectionData = lines.get(cursor);
				long serverId = connectionData[0];
				long serverLatency = connectionData[1];
				Server server = data.getServer((int) serverId);
				endpoint.addConnection(server, serverLatency);
			}
		}

		for (; cursor < lines.size(); cursor++) {
			long[] videoRequestData = lines.get(cursor);
			long videoId = videoRequestData[0];
			long endpointId = videoRequestData[1];
			long requestCount = videoRequestData[2];

			Video video = data.getVideo((int) videoId);
			Endpoint endpoint = data.getEndpoint((int) endpointId);
			endpoint.addRequestPerVideo(video, requestCount);
		}

		return data;
	}
}