package grocery;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseFolder.BaseClass;
import utilityFolder.ActionClass;
import utilityFolder.WaitClass;

public class GroceryPage extends BaseClass {
	WebDriver driver;
	WaitClass wait;
	ActionClass action;
	public GroceryPage(WebDriver driver) {
		this.driver=driver;
		wait=new WaitClass(driver);
		action=new ActionClass(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//div[text()='Verify Delivery Pincode']")			// delivery Pincode
	WebElement deliveryPincode_visibleText;
	
	@FindBy(how=How.XPATH, using="//input[@title='Enter pincode']")									// pincode field
	WebElement pincode_inputField;
	
	
	@FindBy(how=How.XPATH, using="//div[text()='Household Care']")							// House hold option in header of Grocery
	WebElement houseHold_option;
	
	public void enteringPincodeNotByDefault() {
		try {
			if(deliveryPincode_visibleText.isDisplayed()) {
				Thread.sleep(1000);
				pincode_inputField.sendKeys("560037");
				Thread.sleep(1500);
				//WebElement ele=driver.findElement(By.xpath("//input[@title='Enter pincode']/parent::*"));
				
				action.enterOnElement(pincode_inputField);
				Thread.sleep(1000);
			/*	WebElement location=driver.findElement(By.xpath("//button[text()='Current Location']"));
				location.click();*/
			}
		} catch (Exception e) {
			log.info("No delivery dilog box is displayed");
		}
	}
	
	
	
	public void selectFromHouseHold(String main_Option, String detail_Option) {				// Generic method for select items from House Hold
		action.mouseOver(houseHold_option);
		WebElement main=driver.findElement(By.xpath("//div[text()='Household Care']/parent::div/following-sibling::div/descendant::a[contains(text(),'"+main_Option+"')]"));
		wait.elementToBeVisible(main);
		action.mouseOver(main);
		
		WebElement detail=driver.findElement(By.xpath("//a[text()='Repellants & Fresheners']/parent::div/following-sibling::div/descendant::a[contains(text(),'"+detail_Option+"')]"));
		wait.elementClickable(detail);
		detail.click();
	}

}
