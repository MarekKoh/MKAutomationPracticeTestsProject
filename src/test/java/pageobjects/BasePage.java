package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.RandomUser;

public class BasePage {

    protected final static String BASE_URL = "http://automationpractice.com/index.php";
    protected WebDriver driver;

    @FindBy(id="search_query_top")
    WebElement searchBox;

    @FindBy(className="logout")
    WebElement signOutButton;

    @FindBy(className="login")
    WebElement goToLoginPageButton;

    @FindBy(id="newsletter-input")
    WebElement newsletterBox;

    @FindBy(xpath = "//button[@name='submitNewsletter']" )
    WebElement submitNewsletterButton;

    @FindBy(css = ".alert alert-success")
    WebElement newsletterSuccessAlert;



    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void goToLoginPage() {
        goToLoginPageButton.click();
    }

    public boolean isUserLoggedIn() {
        return signOutButton.isDisplayed();
    }

    public void subscribeToNewsletter(String email) {
        newsletterBox.sendKeys(email);
        submitNewsletterButton.click();
    }
    public boolean isNewsletterAlertDisplayed(String expectedAlertText) {
        return newsletterSuccessAlert.getText().contains(expectedAlertText);
    }
}
