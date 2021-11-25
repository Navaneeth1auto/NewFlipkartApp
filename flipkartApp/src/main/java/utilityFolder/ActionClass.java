package utilityFolder;

import java.awt.RenderingHints.Key;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseFolder.BaseClass;

public class ActionClass extends BaseClass{
	WebDriver driver;
	Actions action;
	WaitClass wait;
	public ActionClass(WebDriver driver) {
		
		this.driver=driver;
		action=new Actions(driver);
		wait=new WaitClass(driver);
	}
	
	public void mouseOver(WebElement element) {
		wait.elementToBeVisible(element);
		action.moveToElement(element).build().perform();
	}
	
	public void enterOnElement(WebElement element) {
		wait.elementIsDisplayed(element);
		action.sendKeys(element, Keys.ENTER).build().perform();
	}
}
