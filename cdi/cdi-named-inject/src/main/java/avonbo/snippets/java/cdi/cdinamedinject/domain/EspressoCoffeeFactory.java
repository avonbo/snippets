package avonbo.snippets.java.cdi.cdinamedinject.domain;

import javax.inject.Named;

@Named("espresso")
public class EspressoCoffeeFactory implements CoffeeFactory{

	public Coffee createCoffee() {
		return new Coffee("espresso");
	}

}
