package avonbo.snippets.java.java8.lambda;

@FunctionalInterface
interface PersonFactory<P extends Person> {
	P create(String firstName, String lastName);
}
