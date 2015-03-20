package avonbo.snippets.java.jndi.initialcontextfactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyClient {

	private MyServer serverDE;
	private MyServer serverEN;
	
	/**
	 * Lookup on intialization is not the best idea, but for a demo its ok
	 */
	public MyClient() throws NamingException{
		Context ctx = new InitialContext();
		serverDE = (MyServer) ctx.lookup("java:global/services/helloServcieDE");
		serverEN = (MyServer) ctx.lookup("java:global/services/helloServcieEN");
	}
	
	public String sayHello(){
		String result = serverEN.sayHello();
		return result;
	}
	
	public String sagHallo(){
		String result = serverDE.sayHello();
		return result;
	}
}
