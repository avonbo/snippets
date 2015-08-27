package avonbo.snippets.java.actor;

/**
 *
 * @author Alexander von Boguszewski
 *
 * @param <T>
 */
public interface Actor<T> {

	/**
	 * sends a message to all behaviors
	 * @param body
	 */
	public abstract void publish(T body);

}