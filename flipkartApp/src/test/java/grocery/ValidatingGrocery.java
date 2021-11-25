package grocery;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseFolder.BaseClass;
import classPages.HomePage;

public class ValidatingGrocery extends BaseClass{
	HomePage home;
	GroceryPage grocery;
	
	@BeforeMethod
	public void clickOnGrocery() {
		log=LogManager.getLogger();
		home=new HomePage(driver);
		home.clickOnGrocery();
		grocery=new GroceryPage(driver);
		grocery.enteringPincodeNotByDefault();
	}
	
	@Test
	public void selectingItemsFromHouseHold() {
		grocery=new GroceryPage(driver);
		grocery.selectFromHouseHold("Basic Electricals", "Batteries");
	}
}
