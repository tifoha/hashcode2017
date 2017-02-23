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
		final StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
		sb.append("S[").append(id);
		sb.append(": ").append(size);
		sb.append(']');
		return sb.toString();
	}
}
