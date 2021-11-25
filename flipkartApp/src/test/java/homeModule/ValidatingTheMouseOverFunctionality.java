package homeModule;


import org.testng.annotations.Test;

import baseFolder.BaseClass;
import classPages.ElectronicPage;
import classPages.HomePage;


public class ValidatingTheMouseOverFunctionality extends BaseClass {
	HomePage home;
	ElectronicPage electro;



	@Test
	public void test1() {
		log.info("ValidatingTheMouseOverFunctionality");
		System.out.println("test1 ");
		home=new HomePage(driver);
		home.mouseOverOnElectricalsHeader();
		electro=new ElectronicPage(driver);
		electro.mouseOnElectronics();
		electro.clickOnApple();
	}

}
