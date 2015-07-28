package avonbo.snippets.java.actor;

public interface Behavior<T> {

    boolean receive(T msg);

    void exception(Exception e);
}
