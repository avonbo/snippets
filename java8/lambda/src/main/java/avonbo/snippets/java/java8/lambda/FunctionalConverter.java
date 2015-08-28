package avonbo.snippets.java.java8.lambda;

@FunctionalInterface
public interface FunctionalConverter<I,O> {

	O convert(I input);

}
