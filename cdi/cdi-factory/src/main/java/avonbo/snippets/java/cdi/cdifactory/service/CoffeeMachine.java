package avonbo.snippets.java.cdi.cdifactory.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import avonbo.snippets.java.cdi.cdifactory.domain.brewunit.CoffeeMaker;
import avonbo.snippets.java.cdi.cdifactory.domain.coffee.Coffee;

@Singleton
public class CoffeeMachine {

	@Inject
	@Named("espresso")
	CoffeeMaker coffeeMaker;

	public Coffee brewCoffee() {
		return coffeeMaker.brewCoffee();
	}

}
