package avonbo.snippets.java.actor;

public class ReceivedMessageCheckingBehaviour implements Behavior<MyMessage> {

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
	public boolean receive(MyMessage msg) {
		try{
			System.out.println("Receive myMessage=" + msg);
			myMessage = msg.getMessage();
			msg.setMessage(myMessage + " > Got on " + System.currentTimeMillis());
		} catch (final Exception e) {
			myException = e;
			return false;
		}
		return true;
	}

}
