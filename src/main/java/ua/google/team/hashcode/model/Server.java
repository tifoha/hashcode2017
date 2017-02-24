package ua.google.team.hashcode.model;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Vitaliy Sereda on 23.02.17.
 */
public class Server {
	public  long id;
	public  long size;
	public Set<Video> videos = new LinkedHashSet<>();

	public Server() {
	}

	public Server(long id, long size) {
		this.id = id;
		this.size = size;
	}

	public long getId() {
		return id;
	}

	public long getSize() {
		return size;
	}

	@Override
	public String toString() {
		return String.format("S%03d[%d]", id, size);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Server)) return false;

		Server server = (Server) o;

		return id == server.id;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}
}
