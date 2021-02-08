package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="email_create")
    WebElement emailCreateNewUserBox;

    @FindBy(id="email")
    WebElement emailAlreadyRegisteredUserBox;

    @FindBy(id="passwd")
    WebElement passwordAlreadyRegisteredUserBox;

    @FindBy(id="SubmitLogin")
    WebElement SubmitLoginButton;

    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedOut() {
        return SubmitLoginButton.isDisplayed();
    }

    public boolean isUserLoggedIn() {
        return signOutButton.isDisplayed();
    }

    public void goToRegisterPage(String email) {
        emailCreateNewUserBox.sendKeys(email);
        emailCreateNewUserBox.sendKeys(Keys.ENTER);
    }
    public void goToUsersAccountPage(String email, String password) {
        emailAlreadyRegisteredUserBox.sendKeys(email);
        passwordAlreadyRegisteredUserBox.sendKeys(password);
        SubmitLoginButton.click();
    }
}
