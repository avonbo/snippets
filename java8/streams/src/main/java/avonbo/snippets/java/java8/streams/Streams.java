package avonbo.snippets.java.java8.streams;

import java.util.ArrayList;
import java.util.List;

public class Streams {


	public static List<String> sort(List<String> in){
		final List<String> out = new ArrayList<>();

		in.stream()
		.sorted().forEach((s) -> out.add(s));

		return out;
	}

	public static List<String> startsWith(List<String> in, String start){
		final List<String> out = new ArrayList<>();

		in.stream()
		.filter((s) -> s.startsWith(start))
		.forEach((s) -> out.add(s));

		return out;
	}

}
