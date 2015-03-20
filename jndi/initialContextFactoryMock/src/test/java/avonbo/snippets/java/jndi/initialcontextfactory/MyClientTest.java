package avonbo.snippets.java.jndi.initialcontextfactory;

import static org.junit.Assert.*;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;


public class MyClientTest {
	
	MyClient client;
	
	@Before
	public void init() throws NamingException {

		MockInitialContextFactory.bind(
				"java:global/services/helloServcieDE",
				new MyServer("Hallo"));
		
		MockInitialContextFactory.bind(
				"java:global/services/helloServcieEN",
				new MyServer("Hello"));

		client = new MyClient();
	}

	@Test
	public void test() {
		assertEquals("Hallo", client.sagHallo());		
		assertEquals("Hello", client.sayHello());
	}

}
