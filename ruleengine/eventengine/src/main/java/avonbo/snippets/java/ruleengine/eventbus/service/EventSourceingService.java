package avonbo.snippets.java.ruleengine.eventbus.service;

import java.util.Map;

import javax.ejb.Local;
import javax.naming.NamingException;


@Local
public interface EventSourceingService {

	public void add(String type, String name);

	public void add(String type, String name, Map<String, Object> properties);

	public void registerProcessConsumer(String expression, String processToStart)
			throws NamingException;
}
