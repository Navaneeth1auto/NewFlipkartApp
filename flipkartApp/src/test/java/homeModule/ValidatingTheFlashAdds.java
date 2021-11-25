package homeModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseFolder.BaseClass;
import classPages.HomePage;
import utilityFolder.JavascriptExecutorClass;
import utilityFolder.WaitClass;

public class ValidatingTheFlashAdds extends BaseClass{
	WaitClass wait;
	JavascriptExecutorClass js;
	@Test
	public void ClickOnFlashAdds() throws Throwable {
				wait=new WaitClass(driver);
				WebElement tab=driver.findElement(By.xpath("(//div[@style='width: 1333px;']/descendant::img[@alt='tab'])[2]"));
				wait.elementIsDisplayed(tab);
				js=new JavascriptExecutorClass(driver);
				js.clickUsingJavaScript(tab);
				
	}
}
