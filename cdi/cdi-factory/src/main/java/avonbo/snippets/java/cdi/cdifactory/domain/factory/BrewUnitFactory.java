package avonbo.snippets.java.cdi.cdifactory.domain.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import avonbo.snippets.java.cdi.cdifactory.domain.brewunit.CoffeeMaker;
import avonbo.snippets.java.cdi.cdifactory.domain.brewunit.EspressoMaker;
import avonbo.snippets.java.cdi.cdifactory.domain.brewunit.LungoMaker;

public class BrewUnitFactory {

	@Produces
	@Named("espresso")
	public CoffeeMaker produceEspressoMaker(){
		return new EspressoMaker();
	}
	
	@Produces
	@Named("lungo")
	public CoffeeMaker produceLungoMaker(){
		return new LungoMaker();
	}
}
