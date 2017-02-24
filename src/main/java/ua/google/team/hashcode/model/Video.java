package ua.google.team.hashcode.model;

public class Video {
	private final long id;
	private final long size;

	public Video(long id, long size) {
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
		return String.format("V%03d[%d]", id, size);
	}

}
