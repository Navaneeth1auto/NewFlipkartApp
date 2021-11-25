package topOffers;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseFolder.BaseClass;
import classPages.DealOfTheDayPage;
import classPages.HomePage;
import classPages.OffersPage;
import utilityFolder.JavascriptExecutorClass;

public class CheckingResultsOfDealOfTheDay extends BaseClass{
	HomePage home;
	OffersPage offer;
	DealOfTheDayPage deal;
	JavascriptExecutorClass scroll;
	@Test
	public void printingListOfItemsInDealOfDay() throws Throwable {
		home=new HomePage(driver);
		home.clickOnTopOfferHeader();
		offer=new OffersPage(driver);
		offer.clickOnDealOfTheDayViewAllBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deal=new DealOfTheDayPage(driver);
		int n,m;
		scroll=new JavascriptExecutorClass(driver);
		do {
			n=deal.itemsCount();
			scroll.scrollDown();
			Thread.sleep(5000);
			m=deal.itemsCount();
			System.out.println("n value is: "+n+" m value is: "+m);
		} while (m>n);
		
		
		log.info("number of products in deal of the day page are : "+n);
		for(int i=1;i<=n;i++) {
			System.out.println(deal.productName(i)+"\t   "+ deal.offerDeals(i)+"\t    "+ deal.extralDeals(i));
		}
	}

}
