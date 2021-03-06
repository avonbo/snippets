package avonbo.snippets.java.jndi.initialcontextfactory;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

public class MockInitialContextFactory implements InitialContextFactory {

	private static InitialContext context;

	static {
		try {
			context = new InitialContext(true) {
				Map<String, Object> bindings = new HashMap<String, Object>();

				@Override
				public void bind(String name, Object obj) throws NamingException {
					bindings.put(name, obj);
				}

				@Override
				public Object lookup(String name) throws NamingException {
					return bindings.get(name);
				}
			};

			final String contextFactoryName = MockInitialContextFactory.class.getName();
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY, contextFactoryName);

		} catch (final NamingException e) { // can't happen?
			throw new RuntimeException(e);
		}
	}

	public static void bind(String name, Object obj) {
		try {
			context.bind(name, obj);
		} catch (final NamingException e) { // can't happen.
			throw new RuntimeException(e);
		}
	}

	public static InitialContext getInitialContext() throws NamingException {
		return context;
	}

	public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
		return context;
	}

}