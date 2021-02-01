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

    public LoginPage(WebDriver driver) {
        super(driver);
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
