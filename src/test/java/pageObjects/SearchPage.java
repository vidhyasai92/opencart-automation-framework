
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Search results + product detail actions.
 */
public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // All product titles on the search results grid
    @FindBy(xpath = "//div[@class='product-thumb']//h4/a")
    private List<WebElement> productTitles;

    // Product detail page elements
    @FindBy(id = "input-quantity")
    private WebElement txtQuantity;

    @FindBy(id = "button-cart")
    private WebElement btnAddToCart;

    // Success banner after adding to cart
    @FindBy(css = "div.alert-success")
    private WebElement msgSuccess;

    /** Returns true if an exact product name exists in results. */
    public boolean isProductExist(String productName) {
        for (WebElement e : productTitles) {
            if (e.getText().trim().equalsIgnoreCase(productName.trim())) {
                return true;
            }
        }
        return false;
    }

    /** Clicks a product in results by its visible name. */
    public void selectProduct(String productName) {
        // Try from cached list first
        for (WebElement e : productTitles) {
            if (e.getText().trim().equalsIgnoreCase(productName.trim())) {
                e.click();
                return;
            }
        }
        // Fallback: direct locator if list not populated
        driver.findElement(By.xpath("//div[@class='product-thumb']//h4/a[normalize-space()='" 
                                    + productName + "']")).click();
    }

    /** Sets quantity on the product detail page. */
    public void setQuantity(String qty) {
        txtQuantity.clear();
        txtQuantity.sendKeys(qty);
    }

    /** Clicks Add to Cart on the product detail page. */
    public void addToCart() {
        btnAddToCart.click();
    }

    /** True if the green success banner appears after add to cart. */
    public boolean checkConfMsg() {
        try {
            return msgSuccess.isDisplayed() && msgSuccess.getText().toLowerCase().contains("success");
        } catch (Exception e) {
            return false;
        }
    }
}

