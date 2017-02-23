package ua.google.team.hashcode.commons;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ua.google.team.hashcode.model.Endpoint;
import ua.google.team.hashcode.model.Server;
import ua.google.team.hashcode.model.Video;

public class InputParser {

        static int videosCount, endPointsCount, requestDescriptionsCount, cachesCount, cacheSize;
        static String test;

        public static void main(String[] args) throws IOException {
            InputParser obj = new InputParser();
            obj.getFile("me_at_the_zoo.in");
//            obj.getFile("me_at_the_zoo.in");
            System.out.println("count of Videos " + videosCount);
            System.out.println("count of endPoints " + endPointsCount);
            System.out.println("count of requests " + requestDescriptionsCount);
            System.out.println("count of Caches " + cachesCount);
        }

        private void getFile(String fileName) throws IOException {
            Facade facade = new Facade();
//            StringBuilder result = new StringBuilder("");

//            List<Cache> allCaches = new ArrayList<>();
//            List<Video> allVideos = new ArrayList<>();

            ClassLoader classLoader = getClass().getClassLoader();
            Path path = Paths.get(classLoader.getResource(fileName).getFile());
            Pattern pattern = Pattern.compile(" ");
            List<long[]> lines = Files
                    .lines(path)
                    .map(pattern::splitAsStream)
                    .map(s -> s.mapToLong(Long::parseLong).toArray())
//                    .map(Arrays::asList)
                    .collect(toList());

            long[] firsLine = lines.get(0);

            long videoCount = firsLine[0];
            long endpointCount = firsLine[1];
            long reqDescCount = firsLine[2];
            long serverCount = firsLine[3];
            long serverSize = firsLine[4];

            List<Server> servers = new ArrayList<>();
            for (int i = 0; i < serverCount; i++) {
                servers.add(new Server(i, serverSize));
            }

            facade.servers = servers;
            List<Endpoint> endpoints = new ArrayList<>();
//            for (int i = 0; i < endpointCount; i++) {
//                endpoints.add(new Endpoint());
//            }

            List<Video> videos = new ArrayList<>();
            long[] videoInfo = lines.get(1);
            for (int i = 0; i < videoCount; i++) {
                videos.add(new Video(i, videoInfo[i]));
            }
            
            facade.videos = videos;

            int index = 2;
            for (int i = 0; i < endpointCount; i++) {
                long[] epInfo = lines.get(index++);
                long globalLatency = epInfo[0];
                long sCount = epInfo[1];
                Endpoint endpoint = new Endpoint();
                endpoint.globalLatency = globalLatency;
                endpoint.id = i;

                for (; index < sCount; index++) {
                    long[] connectionInfo = lines.get(index);
                    long serverId = connectionInfo[0];
                    long serverLatency = connectionInfo[1];
                    Server server = servers.get((int) serverId);
                    endpoint.serverLatency.put(server, serverLatency);
                }
                endpoints.add(endpoint);
            }

            facade.endpoints = endpoints;

//            long rIndex = lines.size() - lines.size() - reqDescCount;
//            for (int i = lines.size() - li; i < reqDescCount; i++) {
//
//            }


            lines.forEach(System.out::println);


//            System.out.println(strings);

//            try (Scanner scanner = new Scanner(file)) {
//
//                while (scanner.hasNextLine()) {
//                    String line = scanner.nextLine();
////                test = line;
////                try (Scanner scan = new Scanner(line)) {
//                    Scanner scan = new Scanner(line);
//                    while (scan.hasNext()) {
//                        videosCount = scan.nextInt();
//                        endPointsCount = scan.nextInt();
//                        requestDescriptionsCount = scan.nextInt();
//                        cachesCount = scan.nextInt();
//                        cacheSize = scan.nextInt();
////                        for (int i = 0; i < cachesCount; i++) {
////                            allCaches.add(new Cache(i++, cacheSize));
////                        }
////
////                        for (int i = 0; i < videosCount; i++) {
////                            allVideos.add(new Video(i, scan.nextInt()));
////                        }
////                        break;
//                    }
////                    scan.close();
////                } catch (IOException e){
////                    e.printStackTrace();
////                }
////                result.append(line).append("\n");
//                }
//
//                scanner.close();
//
//            }catch(IOException e){
//                e.printStackTrace();
//            }
//            return result.toString();
        }

}