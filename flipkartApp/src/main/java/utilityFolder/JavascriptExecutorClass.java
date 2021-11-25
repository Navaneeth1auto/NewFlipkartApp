package utilityFolder;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseFolder.BaseClass;

public class JavascriptExecutorClass extends BaseClass {
	WebDriver driver;
	JavascriptExecutor js;
	WaitClass wait;
	public JavascriptExecutorClass(WebDriver driver) {
		this.driver=driver;
		wait=new WaitClass(driver);
		js=(JavascriptExecutor)driver;
	}
	
	public void scrollDown()
	{
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollDown(WebElement element) {
		wait.elementToBeVisible(element);
		js.executeScript("arguments[0].scrollIntoView();", element);
		log.info("scroll down to the product");
	}
	
	public void clearUsingJavaScript(WebElement element) {
		js.executeScript("arguments[0].value='';", element);
	}
	
	public void clickUsingJavaScript(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

}
