package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_005AddToCartPage extends BaseClass {

    @Test(groups = {"Master"})
    public void verify_addToCart() throws InterruptedException {
        logger.info("Starting TC_005_AddToCartPageTest");

        try {
            // Navigate to Home Page
            HomePage hp = new HomePage(driver);
            hp.enterProductName("iPhone");
            hp.clickSearch();

            // Search and validate product
            SearchPage sp = new SearchPage(driver);
            if (sp.isProductExist("iPhone")) {
                sp.selectProduct("iPhone");
                sp.setQuantity("2");
                sp.addToCart();
            }

            // Verify confirmation message
            Assert.assertEquals(sp.checkConfMsg(), true, "Add to cart confirmation message is missing!");
            logger.info("Add to Cart test passed successfully.");

        } catch (Exception e) {
            logger.error("Add to Cart test failed due to exception: " + e.getMessage());
            Assert.fail();
        }

        logger.info("Finished TC_005_AddToCartPageTest");
    }
}

