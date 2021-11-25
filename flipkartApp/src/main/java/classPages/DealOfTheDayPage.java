package classPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DealOfTheDayPage {
	WebDriver driver;
	public DealOfTheDayPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='_5_K_qG']/div[@class='_1FNrEw']")
	List<WebElement> NoOfItems;

	public int itemsCount() {
		return NoOfItems.size();
	}
	
	
	
	public String productName(int i) {
		return driver.findElement(By.xpath("(//div[@class='_5_K_qG']/div[@class='_1FNrEw']/descendant::div[@class='_3LU4EM'])["+i+"]")).getText();
	}
	
	public String offerDeals(int i) {
		return driver.findElement(By.xpath("(//div[@class='_5_K_qG']/div[@class='_1FNrEw']/descendant::div[@class='_2tDhp2'])["+i+"]")).getText();
	}
	
	public String extralDeals(int i) {
		return driver.findElement(By.xpath("(//div[@class='_5_K_qG']/div[@class='_1FNrEw']/descendant::div[@class='_3khuHA'])["+i+"]")).getText();
	}
}
