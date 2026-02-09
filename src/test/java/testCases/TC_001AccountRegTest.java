package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001AccountRegTest extends BaseClass {
 
    @Test(groups={"Regression","Master"})
    public void verify_account_registration() {
    	
    	logger.info("*** Starting TC001_AccountRegTest ***");
    	try
    	{
        HomePage hp = new HomePage(driver);
       hp.clickMyAccount();
       logger.info("Clicked on my Account link");
       
       hp.clickRegister();
       logger.info("Clicked on Register Link");
       
       AccountRegPage regpage=new AccountRegPage(driver);
       logger.info("Providing customer details");
       
       regpage.setFirstName(randomString().toUpperCase());
       regpage.setLastName(randomString().toUpperCase());
       regpage.setEmail(randomString()+"@gmail.com");
       regpage.setPhoneNumber(randomNumber());
       
       String password=randomAlphaNumeric();
       
       regpage.setPassword(password);
       regpage.setConfirmPassword(password);
       
       regpage.setPolicy();
       regpage.clickContinue();
       logger.info("Validating expected Message");
       
       String confirmsg=regpage.getConfirmationMsg();
       AssertJUnit.assertEquals(confirmsg, "Your Account Has Been Created!");
       logger.info("Your Account has been created");
       
    	}
    	catch(Exception e)
    	{
    		logger.error("Test failed");
    		logger.debug("Debug logs..");
    		AssertJUnit.fail();
    	}
    	logger.info("*** Finishing TC001_AccountRegTest ***");
    }
      
       
    } 
       