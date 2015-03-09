package avonbo.snippets.java.cdi.cdifactory.domain.brewunit;


import avonbo.snippets.java.cdi.cdifactory.domain.coffee.Coffee;
import avonbo.snippets.java.cdi.cdifactory.domain.coffee.Espresso;

public class EspressoMaker implements CoffeeMaker{

	public Coffee brewCoffee(){
		return new Espresso();
	}

	
}
