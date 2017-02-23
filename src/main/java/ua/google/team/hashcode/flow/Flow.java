package ua.google.team.hashcode.flow;


import ua.google.team.hashcode.model.Endpoint;
import ua.google.team.hashcode.model.Server;
import ua.google.team.hashcode.model.Video;

import java.util.Set;

public class Flow {
    private final Set<Video> videos;
    private final Set<Endpoint> endpoints;
    private final Set<Server> servers;
    private final Long globalServerLatency;

    public Flow(Set<Video> videos, Set<Endpoint> endpoints, Set<Server> servers, Long globalServerLatency) {
        this.videos = videos;
        this.endpoints = endpoints;
        this.servers = servers;
        this.globalServerLatency = globalServerLatency;
    }

    //TODO: output????
    public Object optimize() {
        return null;
    }
}
