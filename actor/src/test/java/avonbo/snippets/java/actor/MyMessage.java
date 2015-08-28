package avonbo.snippets.java.actor;

public class MyMessage {

	private String message;
	private int count = 0;

	public int getCount() {
		return count;
	}

	public String getMessage() {
		count++;
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
