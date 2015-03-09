package avonbo.snippets.java.cdi.cdiinject;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.core.api.provider.BeanProvider;

public class CDIContainerApp {
	
	public static CDIContainerApp INSTANCE;
	
	public static void init(){
		if(INSTANCE!=null){
			try {
				INSTANCE.finalize();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			INSTANCE=null;
		}
		INSTANCE = new CDIContainerApp();
	}

	private CdiContainer cdiContainer;

	public CDIContainerApp() {

		cdiContainer = CdiContainerLoader.getCdiContainer();
		cdiContainer.boot();

		// now we can use CDI
		// but the container does not automatically start all CDI Contexts.
		// Contexts must be started independently using the provided
		// ContextControl class
		ContextControl contextControl = cdiContainer.getContextControl();
		contextControl.startContext(ApplicationScoped.class);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				cdiContainer.shutdown();
			}
		});

	}
	
	public <T> T getBean(Class<T> type) {
		
		return BeanProvider.getContextualReference(type, false);
    }
}
