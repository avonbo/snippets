package avonbo.snippets.java.cdi.cdifactory;

import avonbo.snippets.java.cdi.cdifactory.domain.coffee.Coffee;
import avonbo.snippets.java.cdi.cdifactory.service.CoffeeMachine;

public class MainApp {

	public static void main(String[] args) {
		CDIContainerApp.init();

		CoffeeMachine coffeeMaker = CDIContainerApp.INSTANCE
				.getBean(CoffeeMachine.class);
		Coffee coffee = coffeeMaker.brewCoffee();

		System.out.println("Brewed " + coffee.getName());
		
		Coffee coffee2 = coffeeMaker.brewCoffee();

		System.out.println("Brewed " + coffee2.getName());

	}

}
