package avonbo.snippets.java.cdi.cdiinject.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import avonbo.snippets.java.cdi.cdiinject.domain.Coffee;
import avonbo.snippets.java.cdi.cdiinject.domain.CoffeeFactory;

@Singleton
public class CoffeeMaker {

	@Inject
	CoffeeFactory coffeeFactory;

	public Coffee brewCoffee() {
		return coffeeFactory.createCoffee();
	}

}
