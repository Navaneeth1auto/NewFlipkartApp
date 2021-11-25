package classPages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseFolder.BaseClass;
import utilityFolder.WaitClass;

public class CartPage extends BaseClass{
	WebDriver driver;
	WaitClass wait;
	public CartPage(WebDriver driver) {
		log=LogManager.getLogger();
		this.driver=driver;
		wait=new WaitClass(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//img[@title='Flipkart']")
	WebElement flipkartLogo;																		// FlipKart logo element
	
	@FindBy(how=How.XPATH, using="//div[text()='Login to see the items you added previously']")
	WebElement msgForNotLoginUser;																	// Msg displayed for not login user cart
	
	@FindBy(how=How.XPATH, using="//div[text()='Your cart is empty!']")
	WebElement cartEmptyMsgElement;																	// Msg displayed for Empty cart
	
	public void clickOnFlipkartLogo() {
		flipkartLogo.click();
	}
	
	
	public String cartOptionWithOutLogin() {
		log.info("cartOptionWithOutLogin");
		wait.elementIsDisplayed(msgForNotLoginUser);
		return msgForNotLoginUser.getText();
	}
	
	public String emptyCartMsg() {
		log.info("emptyCartMsg");
		wait.elementIsDisplayed(cartEmptyMsgElement);
		return cartEmptyMsgElement.getText();
	}
}
