package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Billing & Delivery Form ----------
    @FindBy(xpath="//input[@id='input-payment-firstname']")
    WebElement txtFirstName;

    @FindBy(xpath="//input[@id='input-payment-lastname']")
    WebElement txtLastName;

    @FindBy(xpath="//input[@id='input-payment-address-1']")
    WebElement txtAddress1;

    @FindBy(xpath="//input[@id='input-payment-address-2']")
    WebElement txtAddress2;

    @FindBy(xpath="//input[@id='input-payment-city']")
    WebElement txtCity;

    @FindBy(xpath="//input[@id='input-payment-postcode']")
    WebElement txtPostCode;

    @FindBy(xpath="//select[@id='input-payment-country']")
    WebElement drpCountry;

    @FindBy(xpath="//select[@id='input-payment-zone']")
    WebElement drpState;

    // ---------- Continue Buttons ----------
    @FindBy(xpath="//input[@id='button-payment-address']")
    WebElement btnContinueAfterBillingAddress;

    @FindBy(xpath="//input[@id='button-shipping-address']")
    WebElement btnContinueAfterDeliveryAddress;

    @FindBy(xpath="//textarea[@name='comment']")
    WebElement txtDeliveryMethodComment;

    @FindBy(xpath="//input[@id='button-shipping-method']")
    WebElement btnContinueAfterDeliveryMethod;

    @FindBy(xpath="//input[@name='agree']")
    WebElement chkTermsAndConditions;

    @FindBy(xpath="//input[@id='button-payment-method']")
    WebElement btnContinueAfterPaymentMethod;

    @FindBy(xpath="//input[@id='button-confirm']")
    WebElement btnConfirmOrder;

    @FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
    WebElement msgOrderPlaced;


    // ---------- Actions ----------
    public void setFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastName.sendKeys(lname);
    }

    public void setAddress1(String address1) {
        txtAddress1.sendKeys(address1);
    }

    public void setAddress2(String address2) {
        txtAddress2.sendKeys(address2);
    }

    public void setCity(String city) {
        txtCity.sendKeys(city);
    }

    public void setPostCode(String pcode) {
        txtPostCode.sendKeys(pcode);
    }

    
    public void clickContinueAfterBillingAddress() {
        btnContinueAfterBillingAddress.click();
    }

    public void clickContinueAfterDeliveryAddress() {
        btnContinueAfterDeliveryAddress.click();
    }

    public void setDeliveryMethodComment(String comment) {
        txtDeliveryMethodComment.sendKeys(comment);
    }

    public void clickContinueAfterDeliveryMethod() {
        btnContinueAfterDeliveryMethod.click();
    }

    public void selectTermsAndConditions() {
        chkTermsAndConditions.click();
    }

    public void clickContinueAfterPaymentMethod() {
        btnContinueAfterPaymentMethod.click();
    }

    public void clickConfirmOrder() {
        btnConfirmOrder.click();
    }

    public boolean isOrderPlaced() {
        try {
            return msgOrderPlaced.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
