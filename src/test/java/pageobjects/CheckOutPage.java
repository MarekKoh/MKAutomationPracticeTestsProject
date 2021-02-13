package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends BasePage {

    @FindBy(xpath = "//a[@title=\"Check out\"]")
    WebElement checkoutButton;

    @FindBy(xpath = "//a[@class=\"button btn btn-default standard-checkout button-medium\"]")
    WebElement proceedToCheckOutButton1;

    @FindBy(xpath = "//button[@class=\"button btn btn-default button-medium\"]")
    WebElement proceedToCheckOutButton2;

    @FindBy(xpath = "//button[@class=\"button btn btn-default standard-checkout button-medium\"]")
    WebElement proceedToCheckOutButton3;

    @FindBy(id = "cgv")
    WebElement termsOfServiceCheckBox;

    @FindBy(className = "bankwire")
    WebElement payByBankWire;

    @FindBy(xpath = "//button[@class=\"button btn btn-default button-medium\"]")
    WebElement orderConfirmationButton;

    @FindBy(xpath = "//p[@class=\"cheque-indent\"]")
    WebElement orderConfirmationAlert;

    public CheckOutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goToCheckOutProcess(){
        Actions builder = new Actions(driver);
        builder.moveToElement(shoppingCartButton).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }
    public void finaliseThePurchaseOrder(){
        goToCheckOutProcess();
        proceedToCheckOutButton1.click();
        proceedToCheckOutButton2.click();
        termsOfServiceCheckBox.click();
        proceedToCheckOutButton3.click();
        payByBankWire.click();
        orderConfirmationButton.click();
    }
    public boolean isOrderConfirmationAlertDisplayed() {
        return orderConfirmationAlert.getText().
                contains("Your order on My Store is complete.");
    }
}
