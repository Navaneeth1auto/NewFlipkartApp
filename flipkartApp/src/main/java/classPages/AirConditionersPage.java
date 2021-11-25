package classPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseFolder.BaseClass;
import utilityFolder.JavascriptExecutorClass;
import utilityFolder.WaitClass;

public class AirConditionersPage extends BaseClass{
	WebDriver driver;
	JavascriptExecutorClass js;
	WaitClass wait;
	public AirConditionersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js=new JavascriptExecutorClass(driver);	
		wait=new WaitClass(driver);
	}
	@FindBy(how=How.XPATH, using="//div[text()='Capacity']")
	WebElement capacityOptions;
	
	@FindBy(how=How.XPATH, using="//div[text()='Energy Rating']")
	WebElement EnergyRatingOptions;
	
	public void clickcapacityOptionsInFilter() throws Throwable {
		js.scrollDown(capacityOptions);
		Thread.sleep(1000);
		wait.elementClickable(capacityOptions);
		js.clickUsingJavaScript(capacityOptions);
	}
	
	public void selectCapacity(String capacity) throws Throwable {
		WebElement tons=driver.findElement(By.xpath("//div[contains(text(),'"+capacity+"')]"));
		Thread.sleep(2000);
		tons.click();
	}
	
	public void clickOnEnergyRationOption() throws InterruptedException {
		Thread.sleep(1000);
		js.scrollDown(EnergyRatingOptions);
		Thread.sleep(1000);
		wait.elementClickable(EnergyRatingOptions);
		js.clickUsingJavaScript(EnergyRatingOptions);
	}
	
	public void selectEneryRating(String rating) {
		WebElement rate=driver.findElement(By.xpath("//div[text()='Energy Rating']/ancestor::section/descendant::div[text()='"+rating+"']"));
		wait.elementClickable(rate);
		rate.click();
	}
}
