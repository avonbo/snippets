package avonbo.snippets.java.actor;

public class ReceivedMessageCheckingBehaviour implements Behavior<String> {

    private String myMessage;
    private Exception myException;

    @Override
    public boolean receive(String msg) {
        System.out.println("Receive myMessage=" + msg);
        this.myMessage = msg;
        return false;
    }

    @Override
    public void exception(Exception e) {
        System.out.println("Receive myExcepiont=" + e.getMessage());

    }

    public String getMessage() {
        return this.myMessage;
    }

    public Exception getMyException() {
        return this.myException;
    }

}
