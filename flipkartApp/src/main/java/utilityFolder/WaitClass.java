package utilityFolder;

import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseFolder.BaseClass;

public class WaitClass extends BaseClass{
	WebDriverWait wait;
	JavascriptExecutor js;
	public WaitClass(WebDriver driver) {
		wait=new WebDriverWait(driver, 10);
	}

	public void elementClickable(WebElement element) {                   // Element to be Clickable
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void elementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void elementIsDisplayed(WebElement element) {                   //  Is Displayed 
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForPageLoad() {
		
		//wait.until( js.executeScript("return document.readyState !== 'loading'"));
		//wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState !== 'loading'"));
		wait.until(d -> ((JavascriptExecutor) d).executeScript("return (document.readyState === 'complete' || document.readyState === 'interactive')"));
	}
}
