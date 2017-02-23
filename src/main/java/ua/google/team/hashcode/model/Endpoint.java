package ua.google.team.hashcode.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Endpoint {
    public long id;
    public Map<Video, Long> videoRequests = new LinkedHashMap<>();
    public Map<Server, Long> serverLatency = new LinkedHashMap<>();
    public long globalLatency;

    public Endpoint() {
    }

    public Endpoint(long id, Map<Video, Long> videoRequests, Map<Server, Long> serverLatency, Long globalLatency) {
        this.id = id;
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
