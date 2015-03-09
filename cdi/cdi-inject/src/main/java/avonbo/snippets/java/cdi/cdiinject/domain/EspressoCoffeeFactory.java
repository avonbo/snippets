package avonbo.snippets.java.cdi.cdiinject.domain;

public class EspressoCoffeeFactory implements CoffeeFactory{

	public Coffee createCoffee() {
		return new Coffee("espresso");
	}

}
