package avonbo.snippets.java.actor;

/**
 *
 * @author Alexander von Boguszewski
 *
 * @param <T>
 */
public interface Behavior<T> {

	/**
	 * performs the exception handling when exception occurs in receive task
	 * @param e
	 */
	void exception(Exception e);

	/**
	 * performs the businesslogic when messages receive
	 * @param msg
	 * @return
	 */
	boolean receive(T msg);
}
