package classPages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseFolder.BaseClass;
import utilityFolder.JavascriptExecutorClass;
import utilityFolder.WaitClass;

public class TravelPage extends BaseClass {
	WebDriver driver;
	WaitClass wait;
	JavascriptExecutorClass js;
	public TravelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WaitClass(driver);
		js=new JavascriptExecutorClass(driver);
	}

	@FindBy(how=How.XPATH, using="//label[text()='From']/preceding-sibling::input")
	WebElement from_txtBox;
	
	@FindBy(how=How.XPATH, using="//label[text()='To']/preceding-sibling::input")
	WebElement to_txtBox;
	
	@FindBy(how=How.XPATH, using="//th[@colspan='5']/following-sibling::th/descendant::button")
	WebElement nextBtnCalender;
	
	@FindBy(how=How.XPATH, using="//label[text()='Travellers | Class']/preceding-sibling::input")
	WebElement traveller_class;
	
	@FindBy(how=How.XPATH, using="(//div[text()='Children'] /parent::div/following-sibling::div/descendant::button)[2]")
	WebElement childIncriseInPassingers;
	
	@FindBy(how=How.XPATH, using="(//div[text()='Infants'] /parent::div/following-sibling::div/descendant::button)[2]")
	WebElement infantsIncriseInPassingers;
	
	@FindBy(how=How.XPATH, using="//span[text()='SEARCH']")
	WebElement search_Btn;
	
	public void tripDetailsToEnter(String from, String to) throws Throwable {
		wait.elementClickable(from_txtBox);
		from_txtBox.click();
		Thread.sleep(3000);
		js.clearUsingJavaScript(from_txtBox);
		Thread.sleep(2000);
		from_txtBox.click();
		Thread.sleep(2000);
		from_txtBox.sendKeys(from);
		Thread.sleep(2000);
		//WebElement mumbai=driver.findElement(By.xpath("//div[@class='_1fa_Yn HQlQNF nAiqQV _18Y7Fu']/descendant::span[contains(text(),'Mumbai')]"));
		WebElement mumbai=driver.findElement(By.xpath("//span[text()='Mumbai']/parent::div/parent::div/parent::div"));
		Thread.sleep(1000);
		//js.clickUsingJavaScript(mumbai);
		mumbai.click();
	
		wait.elementClickable(to_txtBox);
		to_txtBox.clear();
		wait.elementToBeVisible(to_txtBox);
		to_txtBox.sendKeys(to);
		Thread.sleep(1500);
		WebElement bengalurur=driver.findElement(By.xpath("//div[@class='_1fa_Yn HQlQNF nAiqQV _18Y7Fu']/descendant::span[contains(text(),'Bengaluru')]"));
		Thread.sleep(1000);
		bengalurur.click();
	
	}
	
	public void calender(String day, String month, String year) {
		String mon=month+" "+year;
		System.out.println(mon);
		boolean value=true;
		while (value) {
			try {
				driver.findElement(By.xpath("//div[text()='"+mon+"']/ancestor::table/descendant::button[text()='"+day+"']")).click();
				value=false;
			} catch (Exception e) {
				System.out.println("Next month");
				if(nextBtnCalender.isEnabled())
					nextBtnCalender.click();
				else
					value=false;
				
			}
		}
	}
	
	public void incriseChild() {
		traveller_class.click();
		wait.elementToBeVisible(childIncriseInPassingers);
		childIncriseInPassingers.click();
		wait.elementToBeVisible(childIncriseInPassingers);
		childIncriseInPassingers.click();
		wait.elementIsDisplayed(infantsIncriseInPassingers);
		infantsIncriseInPassingers.click();
		search_Btn.click();
	}
}
