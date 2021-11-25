package cart;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseFolder.BaseClass;
import classPages.CartPage;
import classPages.HomePage;
import classPages.LoginPage;
import classPages.SearchResultPage;
import utilityFolder.WindowHandlingClass;

public class ValidatingCart extends BaseClass{
	HomePage home;
	LoginPage login;
	CartPage cart;
	SearchResultPage search;
	WindowHandlingClass window;
	String actualMsg="Login to see the items you added previously";


	public ValidatingCart() {
		log=LogManager.getLogger();

	}

	@Test(priority = 1)
	public void loginMethod() {
		home=new HomePage(driver);
		System.out.println("home 1 : "+home);
		home.clickOnLogin();
		login=new LoginPage(driver);
		login.loginWithUserCredentials(obj.getProperty("USERNAME"), obj.getProperty("PASSWORD"));
		log.info("login successfully");
	}

	@Test(priority = 2)
	public void addItemsToCart() throws Throwable {
		log.info("entering data to search box");
		home=new HomePage(driver);
		driver.navigate().refresh();
		System.out.println("home 2 : "+home);

		home.enterProductToSearchBoxAndClickOnSearch(obj.getProperty("item1"));
		search=new SearchResultPage(driver);
		search.clickingOnProduct(obj.getProperty("item1"));
		window=new WindowHandlingClass(driver);
		window.shiftWindow();
	}
	/*
	@Test()
	public void verifyingCartWithOutLoginToApp() {
		String expectedMsg;
		home=new HomePage(driver);
		home.clickOnCartOption();
		cart=new CartPage(driver);
		expectedMsg=cart.cartOptionWithOutLogin();
		System.out.println("Message Displayed for users not logined in Cart is : "+expectedMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
	}
/*
	@Test(dependsOnMethods = "loginMethod")
	public void cartWithNoItemsAdding() throws Throwable {
		Thread.sleep(2000);
		home=new HomePage(driver);
		home.clickOnCartOption();
		System.out.println("in cart after login");
		cart=new CartPage(driver);
		System.out.println("Message displayed for empty cart is : "+cart.emptyCartMsg() );
		cart.clickOnFlipkartLogo();

		home.mouseOverOnCustName();
		home.logoutFromApp();
	}*/

	@Test(dependsOnMethods = { "loginMethod","addItemsToCart"})
	public void verifingTheItemsAddedToCartAndPresentInCartSameOrNot() throws Throwable {
		System.out.println("verifingTheItemsAddedToCartAndPresentInCartSameOrNot");
		home=new HomePage(driver);
		//home.clickOnCartOption();
		Thread.sleep(1000);
		home.mouseOverOnCustName();
		home.logoutFromApp();
	}


	/*@AfterTest
	public void closeTab() {
		//driver.close();
		driver.findElement(By.xpath("//img[@title='Flipkart']")).click();	
	}*/

}
