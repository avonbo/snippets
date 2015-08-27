package avonbo.snippets.java.jndi.initialcontextfactory;

public class MyServer {

	private final String sayHello;

	public MyServer(String str) {
		sayHello = str;
	}

	public String sayHello() {
		return sayHello;
	}

}
