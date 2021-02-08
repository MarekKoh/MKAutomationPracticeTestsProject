package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersAccountPage extends LoginPage {

    @FindBy(xpath = "//div[@id='center_column']/h1")
    WebElement myAccountHeader;

    public UsersAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMyAccountHeaderDisplayed(String expectedHeaderText){
        return myAccountHeader.getText().contains(expectedHeaderText);
    }

    public void signUserOut() {
        signOutButton.click();
    }

}
