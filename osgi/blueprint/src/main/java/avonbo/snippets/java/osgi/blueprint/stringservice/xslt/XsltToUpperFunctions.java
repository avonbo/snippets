package avonbo.snippets.java.osgi.blueprint.stringservice.xslt;

import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import avonbo.snippets.java.osgi.blueprint.stringservice.ToUpperService;
import avonbo.snippets.java.osgi.blueprint.stringservice.exception.BusinessException;
import avonbo.snippets.java.osgi.blueprint.stringservice.exception.TechnicalException;

/**
 * @author Alexander von Boguszewski (alexander.vonboguszewski@nttdata.com)
 *
 */
public class XsltToUpperFunctions {

	/**
	 * The retriever instance providing database access.
	 */
	private static volatile ToUpperService myService = null;

	/**
	 * Accesses the local customer mapping retriever.
	 * 
	 * @return CustomerMappingRetriever either the current or a newly created
	 *         CustomerMappingRetriever instance.
	 */
	private static ToUpperService getToUpperService() throws InvalidSyntaxException {
		if (myService == null) {
			final ServiceReference reference = FrameworkUtil.getBundle(XsltToUpperFunctions.class).getBundleContext()
					.getServiceReferences("com.dab.esb.service.stringservices.ToUpperService", "(name=ToUpperImpl)")[0];

			myService = (ToUpperService) FrameworkUtil.getBundle(XsltToUpperFunctions.class).getBundleContext()
					.getService(reference);
		}
		return myService;
	}

	public static String toUpper(String lower) throws TechnicalException, BusinessException {

		try {
			return getToUpperService().toUpper(lower);
		} catch (final InvalidSyntaxException ise) {
			throw new TechnicalException(ise);
		}
	}

	private XsltToUpperFunctions() {
		// prevent instantiation
	}

}
