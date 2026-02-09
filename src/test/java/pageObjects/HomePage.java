package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	 
    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement txtSearchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    private WebElement btnSearch;

	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	public void enterProductName(String productName) {
        txtSearchBox.clear();
        txtSearchBox.sendKeys(productName);
    }

    public void clickSearch() {
        btnSearch.click();
    }

	
	
}
