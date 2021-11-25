package baseFolder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import classPages.LoginPage;
import utilityFolder.ScreenShotClass;

@Listeners(utilityFolder.ITestListenersClass.class)
public class BaseClass {
	public static WebDriver driver;
	public static Properties obj;
	FileInputStream fis;
	 public static Logger log;
	 public int nber=100;
	 ScreenShotClass shot;
	 LoginPage login;
	@BeforeSuite
	public void init() {
	  
		log=LogManager.getLogger();
		obj=new Properties();
		try {
			fis=new FileInputStream("C:\\Users\\Navaneeth\\QA_Tester\\Tester2\\flipkartApp\\credentials.properties");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException catch");
			e.printStackTrace();
		}
		try {
			obj.load(fis);
		} catch (IOException e) {
			System.out.println("IOException catch");
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Browser drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@BeforeClass
	public void openApplication() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(obj.getProperty("URL"));
		log.info("opening application");
		login=new LoginPage(driver);
		try {
		login.clickClosebtn();
		log.info(" login screen displayed");
		}
		catch (Exception e) {
			System.out.println("No login screen displayed");
		}
	}

	
	
}
