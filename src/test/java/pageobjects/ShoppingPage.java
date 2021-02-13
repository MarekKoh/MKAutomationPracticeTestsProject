package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ShoppingPage extends BasePage {


    @FindBy(css = ".ajax_block_product")
    List<WebElement> products;

    @FindBy(xpath = "//a[@title='Add to cart']")
    List<WebElement> addToCartButtons;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    WebElement continueShoppingButton;



    Random random = new Random();

    public ShoppingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private void moveMouseToProduct(int index) {
        Actions builder = new Actions(driver);
        builder.moveToElement(products.get(index)).moveToElement(products.get(index)).build().perform();
    }
    private void clickOnAddToCartButton(int index) {
        wait.until(ExpectedConditions.visibilityOf(addToCartButtons.get(index)));
        addToCartButtons.get(index).click();
    }
    private void clickOnContinueShoppingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }
    public void addRandomProductsToTheCart(int productNumber) {
        for (int i = 0; i < productNumber; i++) {
            int randomProductIndex = random.nextInt(products.size() - 1);
            moveMouseToProduct(randomProductIndex);
            clickOnAddToCartButton(randomProductIndex);
            clickOnContinueShoppingButton();
        }
    }
}
