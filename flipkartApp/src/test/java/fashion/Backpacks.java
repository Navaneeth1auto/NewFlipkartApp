package fashion;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseFolder.BaseClass;
import classPages.BagsResultPage;
import classPages.HomePage;

public class Backpacks extends BaseClass{
	HomePage home;
	BagsResultPage bag;
	@BeforeMethod
	public void enteringBackpackNameInSearch() {
		log=LogManager.getLogger();
		home=new HomePage(driver);
		home.enterProductToSearchBoxAndClickOnSearch("skybags");
	}
	
	@Test
	public void verifingTheResultsWithFiltersOnPrice() throws Throwable {
		bag=new BagsResultPage(driver);
		bag.setMinimumValue("1000");
		bag.setMaximumValue("1500");
		bag.printingPrices();
	}

}
