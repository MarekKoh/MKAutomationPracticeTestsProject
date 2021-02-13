package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id="email_create")
    WebElement emailCreateNewUserBox;

    @FindBy(id="email")
    WebElement emailAlreadyRegisteredUserBox;

    @FindBy(id="passwd")
    WebElement passwordAlreadyRegisteredUserBox;

    @FindBy(xpath = "//a[@title=\"Recover your forgotten password\"]")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//button[@class=\"btn btn-default button button-medium\"]")
    WebElement retrievePassButton;

    @FindBy(className = "alert-success")
    WebElement alertBarSuccess;

    @FindBy(id="SubmitLogin")
    WebElement submitLoginButton;

    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutButton;

    @FindBy(className = "alert-danger")
    WebElement authenticationAlert;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isUserLoggedOut() {
        return submitLoginButton.isDisplayed();
    }

    public boolean isUserLoggedIn() {
        return signOutButton.isDisplayed();
    }

    public void goToRegisterPage(String email) {
        emailCreateNewUserBox.sendKeys(email);
        emailCreateNewUserBox.sendKeys(Keys.ENTER);
    }
    public boolean isAlertConfirmationEmailDisplayed() {
        return alertBarSuccess.getText().contains("A confirmation email has been sent");
    }
    public void retrieveForgottenPassword(String email){
        forgotPasswordLink.click();
        emailAlreadyRegisteredUserBox.sendKeys(email);
        retrievePassButton.click();
    }
    public void goToUsersAccountPage(String email, String password) {
        emailAlreadyRegisteredUserBox.sendKeys(email);
        passwordAlreadyRegisteredUserBox.sendKeys(password);
        submitLoginButton.click();
    }
    public boolean isAuthenticationFailedAlertDisplayed(){
        return authenticationAlert.getText().contains("Authentication failed");
    }
}
