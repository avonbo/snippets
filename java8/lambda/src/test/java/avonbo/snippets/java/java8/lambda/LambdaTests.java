package avonbo.snippets.java.java8.lambda;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LambdaTests {

	FirstLambda tester;
	int i = 42;

	@Test
	public void createPersonTest(){
		final Person p = tester.createComplexPerson("Luke", "Skywalker");
		assertEquals("LUKE", p.getFirstName());
	}

	@Before
	public void init(){
		tester = new FirstLambda();
	}

	@Test
	public void stringTester(){
		final boolean b = tester.predicate("Hello World");
		assertEquals(true, b);
	}

	@Test
	public void testConstructor(){
		final Person p = tester.createPerson("Peter", "Pakrer");
		assertEquals("Peter", p.getFirstName());
	}

	@Test
	public void testFunctionalInterface(){
		final FunctionalConverter<String, Integer> converter = (inValue) -> Integer.valueOf(inValue);
		final Integer converted = converter.convert("123");
		assertEquals(123, converted.intValue());
	}

	@Test
	public void testFunctionalInterface2(){
		final FunctionalConverter<String, Integer> converter = (inValue) -> {return Integer.valueOf(inValue) + 2;};
		final Integer converted = converter.convert("123");
		assertEquals(125, converted.intValue());
	}

	@Test
	public   void testScopes() {
		final FunctionalConverter<Integer, String> stringConverter1 = (from) -> {
			i = 23;
			return String.valueOf(from);
		};

		final String i2  = stringConverter1.convert(23);
		assertEquals("23", i2);
		assertEquals(i, 23);

	}

	@Test
	public void testSortLonger() {
		final List<String> aList = Arrays.asList("Zeus", "Hades", "Hera", "Poseidon", "Demeter", "Hestia");
		tester.sortListLonger(aList);
		assertEquals(6, aList.size());
		assertEquals("Demeter", aList.get(5));
		assertEquals("Hades", aList.get(4));
		assertEquals("Hera", aList.get(3));
		assertEquals("Hestia", aList.get(2));
		assertEquals("Poseidon", aList.get(1));
		assertEquals("Zeus", aList.get(0));
	}

	@Test
	public void testSortShorter() {
		final List<String> aList = Arrays.asList("Zeus", "Hades", "Hera", "Poseidon", "Demeter", "Hestia");
		tester.sortListLonger(aList);
		assertEquals(6, aList.size());
		assertEquals("Demeter", aList.get(5));
		assertEquals("Hades", aList.get(4));
		assertEquals("Hera", aList.get(3));
		assertEquals("Hestia", aList.get(2));
		assertEquals("Poseidon", aList.get(1));
		assertEquals("Zeus", aList.get(0));
	}



}
