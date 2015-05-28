package avonbo.snippets.java.osgi.blueprint.stringservice;

import avonbo.snippets.java.osgi.blueprint.stringservice.exception.BusinessException;
import avonbo.snippets.java.osgi.blueprint.stringservice.exception.TechnicalException;

/**
 * Interface for the customer mapping service.
 *  
 * @author Alexander von Boguszewski (alexander.vonboguszewski@nttdata.com)
 *
 */
public interface ToUpperService {
	
	String toUpper(final String lower) 
			throws TechnicalException, BusinessException;		

}
