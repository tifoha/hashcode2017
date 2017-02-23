package ua.tifoha;

/**
 * Created by Vitaliy Sereda on 23.02.17.
 */
public class Server {
	public final int id;
	public final int size;

	public Server(int id, int size) {
		this.id = id;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public int getSize() {
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
