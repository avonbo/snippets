package avonbo.snippets.java.actor;

public interface Behavior<T> {

	void exception(Exception e);

	boolean receive(T msg);
}
