package ua.google.team.hashcode.commons;

import java.util.ArrayList;
import java.util.List;

import ua.google.team.hashcode.model.Endpoint;
import ua.google.team.hashcode.model.Server;
import ua.google.team.hashcode.model.Video;

/**
 * Created by Vitaliy Sereda on 23.02.17.
 */
public class Data {
	private List<Video> videos = new ArrayList<>();
	private List<Server> servers = new ArrayList<>();
	private List<Endpoint> endpoints = new ArrayList<>();

	public List<Video> getVideos() {
		return videos;
	}

	public List<Server> getServers() {
		return servers;
	}

	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	public Video getVideo(int index) {
		return videos.get(index);
	}

	public Server getServer(int index) {
		return servers.get(index);
	}

	public Endpoint getEndpoint(int index) {
		return endpoints.get(index);
	}

	public boolean addVideo(Video video) {
		return videos.add(video);
	}

	public boolean addServer(Server server) {
		return servers.add(server);
	}

	public boolean addEndpoint(Endpoint endpoint) {
		return endpoints.add(endpoint);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Facade{")
		.append("videos=").append(videos)
		.append(", servers=").append(servers)
		.append(", endpoints=").append(endpoints)
		.append('}');
		return sb.toString();
	}
}
