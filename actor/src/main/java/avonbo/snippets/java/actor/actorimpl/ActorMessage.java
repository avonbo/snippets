package avonbo.snippets.java.actor.actorimpl;

/**
 * A generic envolop for messages
 * @author Alexander von Boguszewski
 *
 * @param <T>
 */
public class ActorMessage<T> {

	private T body;

	public T getBody() {
		return this.body;
	}

	public void setBody(T body) {
		this.body = body;
	}

}
