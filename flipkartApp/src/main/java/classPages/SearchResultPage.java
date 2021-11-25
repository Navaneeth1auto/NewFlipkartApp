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

public class SearchResultPage extends BaseClass {
	WebDriver driver;
	WaitClass wait;
	ActionClass action;
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		wait=new WaitClass(driver);
		action=new ActionClass(driver);
		log=LogManager.getLogger();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//img[@title='Flipkart']")
	WebElement flipkartLogo;
	
	@FindBy(how=How.CLASS_NAME, using="_13oc-S")									
	List<WebElement> listOfElementsInPage;										// Search Result products in page 
	
	@FindBy(how=How.XPATH, using="//div[@class='_13oc-S']/descendant::div[@class='_4rR01T']")
	List<WebElement>  listOfProductNames;										//  Names of products
	
	
	public void clickingOnProduct(String prod_Name) {
		log.info("in the product selecting page and click on product");
		wait.elementToBeVisible(driver.findElement(By.xpath("//div[@class='_4rR01T' and contains(text(),'"+prod_Name+"')]")));
		driver.findElement(By.xpath("//div[@class='_4rR01T' and contains(text(),'"+prod_Name+"')]")).click();
	}
	
	public int countOfProductsInPage() {										// count of items in page
		wait.elementIsDisplayed(listOfElementsInPage.get(1));
		return listOfElementsInPage.size();
	}
	
	public void matchingResults(String prod_name) {
		int i=1;
		String productName, config, size, camera, battery;
		Iterator<WebElement> names=listOfProductNames.iterator();
		while(names.hasNext()) {
			productName=driver.findElement(By.xpath("(//div[@class='_13oc-S']/descendant::div[@class='_4rR01T'])["+i+"]")).getText();
			config=driver.findElement(By.xpath("((//div[@class='_13oc-S']/descendant::div[@class='fMghEO'])["+i+"]/descendant::li[@class='rgWa7D'])[1]")).getText();
			size=driver.findElement(By.xpath("((//div[@class='_13oc-S']/descendant::div[@class='fMghEO'])["+i+"]/descendant::li[@class='rgWa7D'])[2]")).getText();
			camera=driver.findElement(By.xpath("((//div[@class='_13oc-S']/descendant::div[@class='fMghEO'])["+i+"]/descendant::li[@class='rgWa7D'])[3]")).getText();
			battery=driver.findElement(By.xpath("((//div[@class='_13oc-S']/descendant::div[@class='fMghEO'])["+i+"]/descendant::li[@class='rgWa7D'])[4]")).getText();
			if(names.next().getText().contains(prod_name)) {
				log.info("************** Product info ********************"+i);
				System.out.println("Product Name : "+productName);
				System.out.println("Configuration : "+config);
				System.out.println("Product sizes : "+size);
				System.out.println("Camera : "+camera);
				System.out.println("Battery : "+battery);
				System.out.println();
			}
			i++;
		}
		
	}
}
