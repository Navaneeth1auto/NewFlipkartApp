package baseFolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityFolder.JavascriptExecutorClass;
import utilityFolder.ScreenShotClass;

public class ExampleMain{
	public static ScreenShotClass shot;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Browser drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		JavascriptExecutorClass js;
		WebElement topOffer=driver.findElement(By.xpath("//button[text()='✕']"));
		js=new JavascriptExecutorClass(driver);
		js.clickUsingJavaScript(topOffer);
		System.out.println("end of program");
	}
	
}
