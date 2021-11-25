package classPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseFolder.BaseClass;
import utilityFolder.WaitClass;

public class LoginPage extends BaseClass{
	WaitClass wait;
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WaitClass(driver);
	}
	
	
	@FindBy(how= How.XPATH, using="//button[text()='✕']")          
	WebElement closeBtn;											// X btn in Login pop up
	
	@FindBy(how=How.XPATH, using="//span[text()='Enter Email/Mobile number']/parent::label/preceding-sibling::input")
	WebElement userNameField;
	
	@FindBy(how=How.XPATH, using="//span[text()='Enter Password']/parent::label/preceding-sibling::input")
	WebElement passwordField;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']/span[text()='Login']")
	WebElement login_btn;
	
	public void clickClosebtn() {
		System.out.println("in clickClosebtn ");
		wait.elementToBeVisible(closeBtn);
		closeBtn.click();
	}
	
	public void loginWithUserCredentials(String userName, String password) {
		userNameField.click();
		userNameField.sendKeys(userName);
		passwordField.click();
		passwordField.sendKeys(password);
		login_btn.click();
	}

}
