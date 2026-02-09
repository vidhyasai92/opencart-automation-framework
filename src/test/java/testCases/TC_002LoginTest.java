package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002LoginTest extends BaseClass{
	
	@Test(groups={"sanity","Master"})
	public void Verify_login()
	{
		logger.info("*** Starting TC001_AccountRegTest ***");
		try
		{
			
			 HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				logger.info("Clicked on Register Link");
				hp.clickLogin();
				logger.info("Clicked on Login Link");
				
				LoginPage lp=new LoginPage(driver);
				lp.setEmail(p.getProperty("email"));
				lp.setPassword(p.getProperty("password"));
				lp.clickLogin();
				
				MyAccountPage myacc=new MyAccountPage(driver);
				boolean targetpage=myacc.isMyAccountPageExist(); 
			
		
		Assert.assertEquals(targetpage, true,"LoginFailed");
		}
		catch(Exception e)
		{
			Assert.fail();
		} 
		logger.info("*** Finishing TC002_LoginTest ***"); 
	}  
	

} 
