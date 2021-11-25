package utilityFolder;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseFolder.BaseClass;

public class WindowHandlingClass extends BaseClass{
	WebDriver driver;
	WaitClass wait;
	String parentWindow;
	public WindowHandlingClass(WebDriver driver) {
		this.driver=driver;
		wait=new WaitClass(driver);
		log=LogManager.getLogger();
	}
	
	public void shiftWindow() throws Throwable {
		log.info("in window swith operation");
		parentWindow=driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window=windows.iterator();
		
		while(window.hasNext()) {
			log.info("inside the while loop of switch window");
			String childWindow=window.next();
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
			driver.switchTo().window(childWindow);
			wait.elementClickable(driver.findElement(By.xpath("//button[text()='ADD TO CART']")));
			driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
			break;
			}
		}
		Thread.sleep(5000);
		//driver.close();
		driver.switchTo().window(parentWindow);
	}
}
