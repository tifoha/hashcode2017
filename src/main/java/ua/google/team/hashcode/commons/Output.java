package ua.google.team.hashcode.commons;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Vasyl Zarva.
 */
public class Output {

	public static final String SPACE = " ";
	public static final String OUTPUT_FILE_NAME = "result.in";

	/**
	 * Write results.
	 *
	 * @param map
	 * 		result map of Map<Server id, Set<Video id>>
	 */
	public static void write(Map<Long, Set<Long>> map) {

		// line 1 : N - number of cache servers
		// next lines : server id (V0 - Vn) video ids

		try (final BufferedWriter writer = Files.newBufferedWriter(Paths.get(OUTPUT_FILE_NAME))) {
			final StringBuilder content = new StringBuilder();
			content.append(map.size()).append("\n");
			map.forEach((key, value) ->
					content.append(key)
						   .append(SPACE)
						   .append(value.stream().map(Objects::toString).collect(Collectors.joining(SPACE)))
						   .append("\n")
			);
			writer.write(content.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
