package avonbo.snippets.java.actor.behaviorimpl;

import java.util.logging.Logger;

import avonbo.snippets.java.actor.Behavior;

/**
 * A sample behavior for logging incomming messages
 * @author Alexander von Boguszewski
 *
 * @param <T>
 */
public class LoggingBehaviour<T> implements Behavior<T> {

	private final static Logger logger = Logger.getLogger(LoggingBehaviour.class.getName());

	@Override
	public void exception(Exception e) {
		logger.warning(e.toString());
	}

	@Override
	public boolean receive(T msg) {
		logger.info(msg.toString());
		return true;
	}
}
