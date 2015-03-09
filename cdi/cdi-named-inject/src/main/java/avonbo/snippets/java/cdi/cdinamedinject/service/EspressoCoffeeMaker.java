package avonbo.snippets.java.cdi.cdinamedinject.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import avonbo.snippets.java.cdi.cdinamedinject.domain.Coffee;
import avonbo.snippets.java.cdi.cdinamedinject.domain.CoffeeFactory;

@Singleton
public class EspressoCoffeeMaker {

	@Inject	
	@Named("espresso")
	CoffeeFactory coffeeFactory;

	public Coffee brewCoffee() {
		return coffeeFactory.createCoffee();
	}

}
