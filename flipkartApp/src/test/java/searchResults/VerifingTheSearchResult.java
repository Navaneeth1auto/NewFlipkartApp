package searchResults;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseFolder.BaseClass;
import classPages.HomePage;
import classPages.SearchResultPage;

public class VerifingTheSearchResult extends BaseClass{
	HomePage home;
	SearchResultPage search;
	public VerifingTheSearchResult() {
		log=LogManager.getLogger();
	}
	
	@BeforeMethod
	public void searchingProduct() {
		home=new HomePage(driver);
		home.enterProductToSearchBoxAndClickOnSearch(obj.getProperty("item1"));
		log.info("product entered in search box and clicked on search");
	}
	
	@Test
	public void checkingTheSearchResult() throws InterruptedException {
		log.info("inside the checkingTheSearchResult() method");
		Thread.sleep(5000);
		search=new SearchResultPage(driver);
		log.info("products count is : "+search.countOfProductsInPage());
		search.matchingResults(obj.getProperty("item1"));
	}
	

}
