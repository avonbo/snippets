package avonbo.snippets.java.cdi.cdinamedinject;

import avonbo.snippets.java.cdi.cdinamedinject.domain.Coffee;
import avonbo.snippets.java.cdi.cdinamedinject.service.EspressoCoffeeMaker;

public class MainApp {

	public static void main(String[] args) {
		CDIContainerApp.init();

		EspressoCoffeeMaker coffeeMaker = CDIContainerApp.INSTANCE
				.getBean(EspressoCoffeeMaker.class);
		Coffee coffee = coffeeMaker.brewCoffee();

		System.out.println("Brewed " + coffee.name);

	}

}
