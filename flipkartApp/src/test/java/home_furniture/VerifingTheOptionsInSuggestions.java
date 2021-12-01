package home_furniture;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseFolder.BaseClass;
import classPages.HomePage;

public class VerifingTheOptionsInSuggestions extends BaseClass {
	HomePage home;
	@BeforeMethod
	public void mouseOverElectronics(){
		log=LogManager.getLogger();
		home=new HomePage(driver);
		home.mouseOverOnElectricalsHeader();
		log.info("mouse on Electronics");
	}
	
	@Test
	public void validatingResultsOfSuggestions() throws Throwable {
		home=new HomePage(driver);
		home.mainSuggestionsFromElectronis();
	}
}
