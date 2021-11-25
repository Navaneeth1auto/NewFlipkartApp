package electronics;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseFolder.BaseClass;
import classPages.AirConditionersPage;
import classPages.HomePage;
import utilityFolder.JavascriptExecutorClass;

public class CheckingTheFunctionalityOfFiltersInAC extends BaseClass{
	HomePage home;
	
	AirConditionersPage air;
	@BeforeMethod
	public void clickOnItem() throws Throwable {
		log=LogManager.getLogger();
		home=new HomePage(driver);
		home.mouseOverOnAppliances();
		Thread.sleep(2000);
		home.clickOnAppliance("Air Conditioners");
	}
	
	@Test
	public void capacityFilter() throws Throwable {
		log.info("in side capacity filter");
		air=new AirConditionersPage(driver);
		air.clickcapacityOptionsInFilter();
		air.selectCapacity("1.5 Ton");
		
		air.clickOnEnergyRationOption();
		air.selectCapacity("5 Star");
	}
}
