package avonbo.snippets.java.actor;

public class ReceivedMessageCheckingBehaviour implements Behavior<String> {

	private String myMessage;
	private Exception myException;

	@Override
	public void exception(Exception e) {
		System.out.println("Receive myExcepiont=" + e.getMessage());

	}

	public String getMessage() {
		return myMessage;
	}

	public Exception getMyException() {
		return myException;
	}

	@Override
	public boolean receive(String msg) {
		System.out.println("Receive myMessage=" + msg);
		myMessage = msg;
		return false;
	}

}
