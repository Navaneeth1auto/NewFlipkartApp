package classPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilityFolder.ActionClass;
import utilityFolder.WaitClass;

public class ElectronicPage {
	WebDriver driver;
	WaitClass wait;
	ActionClass action;
	public ElectronicPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WaitClass(driver);
		action=new ActionClass(driver);
	}

	@FindBy(how=How.XPATH, using="//span[text()='Electronics']")       // header Electronics option
	WebElement electronicsHeader;
	
	@FindBy(how=How.XPATH, using="//a[text()='Apple']")
	WebElement appleInElectroList;
	
	public void mouseOnElectronics() {
		action.mouseOver(electronicsHeader);
	}
	
	public void clickOnApple() {
		wait.elementToBeVisible(appleInElectroList);
		appleInElectroList.click();
	}
}
