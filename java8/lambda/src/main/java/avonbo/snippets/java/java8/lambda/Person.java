package avonbo.snippets.java.java8.lambda;

public class Person {

	private String firstName;
	private String lastName;

	Person() {}

	Person(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String setFirstName(String firstName) {
		this.firstName = firstName;
		return firstName;
	}

	public String setLastName(String lastName) {
		this.lastName = lastName;
		return lastName;
	}

}
