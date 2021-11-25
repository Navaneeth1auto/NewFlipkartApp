package utilityFolder;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseFolder.BaseClass;

public class ITestListenersClass extends BaseClass implements ITestListener{
	public ScreenShotClass shot;

	
	public void onTestStart(ITestResult result) {
		System.out.println("***************************************");
		log.info(result.getName()+" has started now");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		log.info("test run successfully "+result.getName());
		shot=new ScreenShotClass(driver);
		shot.screenShotsOfResult(result.getName());
		System.out.println();
	}

	public void onTestFailure(ITestResult result) {
		log.info(result.getName()+" has Failed");
		shot=new ScreenShotClass(driver);
		shot.screenShotsOfResult(result.getName());
		System.out.println();
	}

	public void onTestSkipped(ITestResult result) {
		log.info(result.getName()+" has Skipped");
		System.out.println("**********************************");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
