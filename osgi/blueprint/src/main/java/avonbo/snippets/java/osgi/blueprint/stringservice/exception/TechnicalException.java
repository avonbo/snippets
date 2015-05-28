package avonbo.snippets.java.osgi.blueprint.stringservice.exception;


/**
 * If technical errors occur during the call of 
 * a customer mapping service, this exception is thrown.
 *  
 * @author Zied Mansouri, NTT DATA
 *
 */
public class TechnicalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(Throwable cause) {
		super(cause);
	}

	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
	}
}
