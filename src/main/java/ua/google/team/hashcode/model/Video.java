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
		final StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
		sb.append("V[").append(id);
		sb.append(": ").append(size);
		sb.append(']');
		return sb.toString();
	}
}
