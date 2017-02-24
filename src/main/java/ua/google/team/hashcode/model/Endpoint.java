package ua.google.team.hashcode.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Endpoint {
    private final long id;
    private Map<Video, Long> videoRequests = new LinkedHashMap<>();
    private Map<Server, Long> serverLatency = new LinkedHashMap<>();
    private final long globalLatency;

    public Endpoint(long id, long globalLatency) {
        this.id = id;
        this.globalLatency = globalLatency;
    }

    public Map<Video, Long> getVideoRequests() {
        return videoRequests;
    }

    public Long getGlobalLatency() {
        return globalLatency;
    }

    public Map<Server, Long> getServerLatency() {
        return serverLatency;
    }

    public long getId() {
        return id;
    }

    public void addConnection(Server server, long latency) {
        serverLatency.put(server, latency);
    }

    public void addRequestPerVideo(Video video, long requestCount) {
        videoRequests.put(video, requestCount);
    }

    @Override
    public String toString() {
        return String.format("E%03d[%d]", id, globalLatency);
    }

}
