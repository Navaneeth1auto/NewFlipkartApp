package utilityFolder;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ScreenShotClass {
	WebDriver driver;
	TakesScreenshot screenShot;
	public ScreenShotClass(WebDriver driver) {
		this.driver=driver;
		screenShot=(TakesScreenshot)driver;
	}
	
	public void screenShotsOfResult(String value) {
		
		File scr=  screenShot.getScreenshotAs(OutputType.FILE);
		File dst=new File("C:\\Users\\Navaneeth\\QA_Tester\\Tester2\\flipkartApp\\resultScreenShots\\"+value+".png");
		try {
			FileUtils.copyFile(scr, dst);
		} catch (IOException e) {
			System.out.println("error in screen shot coping");
			e.printStackTrace();
		}
		}
}
