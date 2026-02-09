package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    // header cart button (opens dropdown)
    @FindBy(id = "cart")
    WebElement btnCart;

    // "View Cart" inside dropdown
    @FindBy(xpath = "//strong[normalize-space()='View Cart']/..")
    WebElement lnkViewCart;

    // cart page: Total value cell
    @FindBy(xpath = "//strong[normalize-space()='Total:']/parent::td/following-sibling::td")
    WebElement cellTotal;

    // cart page: Checkout button
    @FindBy(xpath = "//a[contains(@class,'btn') and contains(.,'Checkout')]")
    WebElement btnCheckout;

    public void clickItemsToNavigateToCart() {
        btnCart.click();
    }

    public void clickViewCart() {
        lnkViewCart.click();
    }

    public String getTotalPrice() {
        return cellTotal.getText().trim();
    }

    public void clickOnCheckout() {
        btnCheckout.click();
    }
}

