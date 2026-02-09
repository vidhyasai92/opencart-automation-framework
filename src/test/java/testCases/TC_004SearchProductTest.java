package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004SearchProductTest extends BaseClass {

    @Test(groups = {"Master"})
    public void verify_productSearch() throws InterruptedException {
        logger.info("Starting TC_004_SearchProductTest");

        // Go to home page and search
        HomePage hp = new HomePage(driver);
        // hp.enterProductName("iPhone"); // example alternative
        hp.enterProductName("mac");
        hp.clickSearch();

        // Verify result on search page
        SearchPage sp = new SearchPage(driver);
        boolean found = sp.isProductExist("MacBook");
        Assert.assertTrue(found, "Expected product 'MacBook' was not found in search results.");

        logger.info("Finished TC_004_SearchProductTest");
    }
}
