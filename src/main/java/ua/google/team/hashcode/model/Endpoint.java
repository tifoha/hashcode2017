package ua.google.team.hashcode.model;

import java.util.Map;

public class Endpoint {
    private final Map<Video, Long> videoRequests;
    private final Map<Server, Long> serverLatency;
    private final Long globalLatency;

    public Endpoint(Map<Video, Long> videoRequests, Map<Server, Long> serverLatency, Long globalLatency) {
        this.videoRequests = videoRequests;
        this.serverLatency = serverLatency;
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
}
