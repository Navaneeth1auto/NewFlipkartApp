package classPages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseFolder.BaseClass;
import utilityFolder.ActionClass;
import utilityFolder.JavascriptExecutorClass;
import utilityFolder.SelectClass;

public class BagsResultPage extends BaseClass{
	WebDriver driver;
	ActionClass action;
	SelectClass select;
	JavascriptExecutorClass js;
	public BagsResultPage(WebDriver driver) {
		this.driver=driver;
		action=new ActionClass(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//option[text()='Min']/parent::select")
	WebElement filter_price_min;																	// minimum price drop down SELECT
	
	@FindBy(how=How.XPATH, using="//option[text()='₹5000+']/parent::select")
	WebElement filter_price_max;																	// Maximum price dropdown SELECT
	
	@FindBy(how=How.XPATH, using="//div[text()='SKYBAGS']/following-sibling::a/descendant::div[text()='₹']/preceding-sibling::div")
	List<WebElement> skybags_priceLists;
	
	@FindBy(how=How.XPATH, using="//span[text()='Next']")											// next button in below of page
	WebElement next_btn;
	
	public void setMinimumValue(String min_value) {
		select=new SelectClass(driver);
		select.selectByVisibleText(filter_price_min, min_value);
	}
	
	public void setMaximumValue(String max_value) {
		select=new SelectClass(driver);
		select.selectByVisibleText(filter_price_max, max_value);
	}
	
	public void printingPrices() throws Throwable {
	
		List<String> totalList= new ArrayList<>();
		boolean value=true;
		while (value) {
			Thread.sleep(1000);
			int size=skybags_priceLists.size();
			System.out.println(size);
			for(int i=0;i<size;i++) {
				String price=skybags_priceLists.get(i).getText();
				totalList.add(price);
				System.out.println("the item price is "+i+" : "+price);
			}
			
			try {
				js=new JavascriptExecutorClass(driver);
				js.scrollDown(next_btn);
				next_btn.click();
			} catch (Exception e) {
				log.info("All bags price is stored");
				value=false;
			}
		}
		System.out.println("No of matching products is : "+totalList.size());
		System.out.println(totalList);
	}
}
