package avonbo.snippets.java.java8.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FirstLambda {

	public Person createComplexPerson(String forName, String lastName){
		//Supplier, produce a result of a given generic type
		final Supplier<Person> personSupplier = Person::new;
		final Person p = personSupplier.get();

		//Predicates, boolean-valued functions of one argument
		final Predicate<String> nonNull = Objects::nonNull;
		final boolean firstTest = nonNull.test(forName);
		final boolean secondTest = nonNull.test(lastName);

		if(!firstTest | !secondTest){
			return null;
		}


		//Functions, accept one argument and produce a resul
		final Function<String, String> toUpper = (s) -> s.toUpperCase();

		p.setFirstName(toUpper.apply(forName));
		p.setLastName(toUpper.apply(lastName));

		//Consumers, operations to be performed on a single input.
		final Consumer<Person> greeter = (x) -> System.out.println("Hello, " + x.getFirstName());

		greeter.accept(p);

		return p;
	}

	public Person createPerson(String foreName, String lastName){
		final PersonFactory<Person> personFactory = Person::new;
		return personFactory.create(foreName, lastName);

	}

	public boolean greaterThan(Person person1, Person person2){
		final Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		return comparator.compare(person1, person2) == 1;
	}

	public boolean predicate(String in){
		final Predicate<String> maxLength100 = (s) -> s.length() < 100;

		final Predicate<String> nonNull = Objects::nonNull;
		final Predicate<String> isEmpty = String::isEmpty;
		final Predicate<String> isNotEmpty = isEmpty.negate();

		boolean test = false;

		test = nonNull.test(in);
		if(!test){
			return test;
		}

		test = isNotEmpty.and(maxLength100).test(in);
		return test;
	}

	public void sortListLonger(List<String> aList) {

		// Collections.sort(names, new Comparator<String>() {
		// public int compare(String a, String b) {
		// return b.compareTo(a);
		// }
		// });

		Collections.sort(aList, (String a, String b) -> {
			return b.compareTo(a);
		});

	}

	public void sortListShorter(List<String> aList) {

		//		Collections.sort(aList, (String a, String b) -> {
		//			return b.compareTo(a);
		//		});

		Collections.sort(aList, (a, b) -> b.compareTo(a));

	}

}
