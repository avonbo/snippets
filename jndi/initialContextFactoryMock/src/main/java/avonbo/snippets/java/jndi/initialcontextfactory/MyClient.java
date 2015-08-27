package avonbo.snippets.java.jndi.initialcontextfactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyClient {

	private final MyServer serverDE;
	private final MyServer serverEN;

	/**
	 * Lookup on intialization is not the best idea, but for a demo its ok
	 */
	public MyClient() throws NamingException {
		final Context ctx = new InitialContext();
		serverDE = (MyServer) ctx.lookup("java:global/services/helloServcieDE");
		serverEN = (MyServer) ctx.lookup("java:global/services/helloServcieEN");
	}

	public String sagHallo() {
		final String result = serverDE.sayHello();
		return result;
	}

	public String sayHello() {
		final String result = serverEN.sayHello();
		return result;
	}
}
