package classPages;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseFolder.BaseClass;
import utilityFolder.ActionClass;
import utilityFolder.WaitClass;

public class HomePage extends BaseClass{
		WebDriver driver;
		WaitClass wait;
		ActionClass action;
		public HomePage(WebDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver, this);
			wait=new WaitClass(driver);
			action=new ActionClass(driver);
		}
		
		@FindBy(how=How.XPATH, using="//img[@title='Flipkart']")
		WebElement flipkart_Logo;													// Flipkart LOGO
		
		@FindBy(how=How.XPATH, using="//div[text()='Electronics']")                 // Electronics option in Header prosition
		WebElement electronicsHeader;
		
		@FindBy(how=How.XPATH, using="//div[text()='Electronics']/parent::div/following-sibling::div/descendant::div[5]/a")    
		List<WebElement> mainSuggestionsInElectronis;										// First half of suggestion in Electronics
		
		@FindBy(how=How.XPATH, using="//div[text()='Electronics']/parent::div/following-sibling::div/descendant::div[6]/a")    
		List<WebElement> subSuggestionsInElectronis;										// second half of suggestion in Electronics
		
		
		@FindBy(how=How.XPATH, using="//div[@class='eFQ30H']/descendant::div[text()='Top Offers']")    // Top Offers option in header
		WebElement topOfferHeader;
		
		@FindBy(how=How.XPATH, using="//span[text()='Cart']")                       //  Cart btn in Top of the app
		WebElement cart_btn;
		
		@FindBy(how=How.XPATH, using="//a[text()='Login']")
		WebElement login_btn;														// Login Button in Top of the app
		
		@FindBy(how=How.XPATH, using="(//div[@class='exehdJ'])[1]")
		WebElement customerName;													// Customer Name btn in top of the app
		
		@FindBy(how=How.XPATH, using="//div[text()='Logout']")
		WebElement logout_btn;														// logout button for cust to logout
		
		@FindBy(how=How.CLASS_NAME, using="_3704LK")
		WebElement searchBox;														// Search box element
		
		@FindBy(how=How.CLASS_NAME, using="L0Z3Pu")
		WebElement search_Btn;														// Search Button Element
		
		@FindBy(how=How.XPATH, using="//div[text()='Travel']")						// Travel button in header
		WebElement travel_Btn;
		
		@FindBy(how=How.XPATH, using="//div[text()='Appliances']")					// Appliances option in Header
		WebElement appliances_option;
		
		@FindBy(how=How.XPATH, using="//div[text()='Grocery']")						// Grocery btn in Header
		WebElement grocery_btn;
		
		public void mouseOverOnElectricalsHeader() {
			log.info("in mouseOverOnElectricalsHeader ");
			wait.elementClickable(electronicsHeader);
			action.mouseOver(electronicsHeader);
		}
		
		public void mainSuggestionsFromElectronis() throws Throwable {
			System.out.println("size: "+mainSuggestionsInElectronis.size());
			int mainSize=mainSuggestionsInElectronis.size();
			for(int i=0;i<mainSize;i++) {
				WebElement mainElement=mainSuggestionsInElectronis.get(i);
				action.mouseOver(mainElement);
				int subSize=subSuggestionsInElectronis.size();
				for(int j=0;j<subSize;j++) {
					WebElement subElement=subSuggestionsInElectronis.get(j);
					subElement.click();
					Thread.sleep(2000);
					System.out.println(driver.getTitle());
					Thread.sleep(1500);
					flipkart_Logo.click();
					Thread.sleep(500);
					action.mouseOver(electronicsHeader);
					WebElement element=mainSuggestionsInElectronis.get(i);
					action.mouseOver(element);
				}
			}
			
		}
		
		public void clickOnTopOfferHeader() {							// method for clicking on Top Offer
			log.info("@ clickOnTopOfferHeader");
			wait.elementClickable(topOfferHeader);
			topOfferHeader.click();
		}
		
		public void clickOnCartOption() {                               //  method for clicking Cart Btn
			wait.elementClickable(cart_btn);
			cart_btn.click();
		}
		
		public void clickOnLogin() {									// method for clicking on Login btn
			wait.elementClickable(login_btn);
			login_btn.click();
		}
		
		public void mouseOverOnCustName() {								// Mouse over on Customer Name
			wait.elementIsDisplayed(customerName);
			action.mouseOver(customerName);
		}
		
		public void logoutFromApp() {									// logout functionality
			log.info("logout from app");
			wait.elementIsDisplayed(logout_btn);
			logout_btn.click();
		}
		
		public void clickOnTravel() {
			wait.elementClickable(travel_Btn);
			travel_Btn.click();
		}
		
		public void enterProductToSearchBoxAndClickOnSearch(String data) {				// Search Product from Search Box
			log.info(" Search Product from Search Box");
			wait.elementIsDisplayed(searchBox);
			searchBox.sendKeys(data);
			wait.elementClickable(search_Btn);
			search_Btn.click();
		}
		public void mouseOverOnAppliances() {
			log.info("mouse on Appliances method");
			wait.elementIsDisplayed(appliances_option);
			action.mouseOver(appliances_option);
		}
		public void clickOnAppliance(String itemName) {
			WebElement item=driver.findElement(By.xpath("//a[@class='_6WOcW9' and text()='"+itemName+"']"));
			item.click();
		}
		
		public void clickOnGrocery() {										// click on Grocery btn in header
			wait.elementClickable(grocery_btn);
			grocery_btn.click();
		}
}
