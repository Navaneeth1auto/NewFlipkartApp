package travel;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseFolder.BaseClass;
import classPages.HomePage;
import classPages.TravelPage;

public class ValidatingTheBasicFunctionalities extends BaseClass{
	HomePage home;
	TravelPage travel;
	@BeforeMethod
	public void clickOnTravelInHeader() {
		log=LogManager.getLogger();
		home=new HomePage(driver);
		home.clickOnTravel();
	}
	
	@Test
	public void checkingFromToOptions() throws Throwable {
		travel=new TravelPage(driver);
		travel.tripDetailsToEnter("Mumbai", "Bangaluru");
		log.info("after enting mumbai and bangalore");
		travel.calender("20", "December", "2021");
		travel.incriseChild();
	}
}
