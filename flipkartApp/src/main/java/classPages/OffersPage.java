package classPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilityFolder.WaitClass;

public class OffersPage {
	WebDriver driver;
	WaitClass wait;
	public OffersPage(WebDriver driver) {
		this.driver=driver;
		wait=new WaitClass(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//h2[text()='Deals of the Day']//following-sibling::div[@class='_30kJiF']/a[text()='VIEW ALL']")
	WebElement viewAllBtnOfDealOfTheDay;
	
	public void clickOnDealOfTheDayViewAllBtn() {
		wait.elementClickable(viewAllBtnOfDealOfTheDay);
		viewAllBtnOfDealOfTheDay.click();
	}
}
