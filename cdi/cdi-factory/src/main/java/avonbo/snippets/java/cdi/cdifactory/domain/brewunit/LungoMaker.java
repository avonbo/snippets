package avonbo.snippets.java.cdi.cdifactory.domain.brewunit;

import avonbo.snippets.java.cdi.cdifactory.domain.coffee.Coffee;
import avonbo.snippets.java.cdi.cdifactory.domain.coffee.Lungo;

public class LungoMaker implements CoffeeMaker {

	public Coffee brewCoffee() {
		return new Lungo();
	}

}
