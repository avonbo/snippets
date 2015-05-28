/**
 * The package for customer mapping retrieving tools.
 */
package avonbo.snippets.java.osgi.blueprint.stringservice;

import avonbo.snippets.java.osgi.blueprint.stringservice.exception.BusinessException;
import avonbo.snippets.java.osgi.blueprint.stringservice.exception.TechnicalException;

/**
 * Encapsulates logic for the mapping
 * 
 * @author Alexander von Boguszewski (alexander.vonboguszewski@nttdata.com)
 * 
 */
public class ToUpperServiceImpl implements ToUpperService {

    public String toUpper(String lower) throws TechnicalException, BusinessException {
        if (lower == null || "".equals(lower)) {
            throw new TechnicalException("Parameter ist leer");
        }

        // unsinn
        if (lower.length() < 4) {
            throw new BusinessException("Laenge von " + lower + " muss groesser 4 sein");
        }
        return lower.toUpperCase();
    }

}
