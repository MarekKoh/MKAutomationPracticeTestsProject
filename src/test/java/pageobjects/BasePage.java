package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected final static String BASE_URL = "http://automationpractice.com/index.php";
    protected WebDriver driver;
    protected WebDriverWait wait;

    public String womenCatPageUrl = "http://automationpractice.com/index.php?id_category=3&controller=category";
    @FindBy(id = "search_query_top")
    WebElement searchBox;

    @FindBy(className = "login")
    WebElement goToLoginPageButton;

    @FindBy(id = "newsletter-input")
    WebElement newsletterBox;

    @FindBy(xpath = "//button[@name='submitNewsletter']")
    WebElement submitNewsletterButton;

    @FindBy(xpath = "//p[@class=\"alert alert-success\"]")
    WebElement newsletterSuccessAlert;

    @FindBy(xpath = "//div[@class='shopping_cart']//b")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//a[@class='cart-images']")
    List<WebElement> cartItems;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    public void goToShoppingPage() {
        driver.get(womenCatPageUrl);
    }

    public void searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void goToLoginPage() {
        goToLoginPageButton.click();
    }

    public void subscribeToNewsletter(String email) {
        newsletterBox.sendKeys(email);
        submitNewsletterButton.click();
    }

    public boolean isNewsletterAlertDisplayed() {
        return newsletterSuccessAlert.getText().contains("You have successfully subscribed");
    }
    public int getQuantityOfItemsInTheCart() {
        Actions builder = new Actions(driver);
        builder.moveToElement(shoppingCartButton).build().perform();
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
        return cartItems.size();
    }

}