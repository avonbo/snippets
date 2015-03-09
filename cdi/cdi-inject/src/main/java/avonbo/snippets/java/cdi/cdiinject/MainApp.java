package avonbo.snippets.java.cdi.cdiinject;

import avonbo.snippets.java.cdi.cdiinject.domain.Coffee;
import avonbo.snippets.java.cdi.cdiinject.service.CoffeeMaker;

public class MainApp {

	public static void main(String[] args) {
		CDIContainerApp.init();

		CoffeeMaker coffeeMaker = CDIContainerApp.INSTANCE
				.getBean(CoffeeMaker.class);
		Coffee coffee = coffeeMaker.brewCoffee();

		System.out.println("Brewed " + coffee.name);

	}

}
