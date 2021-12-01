package utilityFolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import baseFolder.BaseClass;

public class SelectClass extends BaseClass{
	WebDriver driver;
	Select select;
	public SelectClass(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectByVisibleText(WebElement element, String text) {
		select=new Select(element);
		select.selectByValue(text);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
