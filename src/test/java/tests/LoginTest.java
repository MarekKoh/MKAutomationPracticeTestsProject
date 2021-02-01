package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.UsersAccountPage;
import utils.RandomUser;

public class LoginTest extends BaseTest {

    @Test
    void shouldLoginUserWithValidData() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToUsersAccountPage("abcd@gmail.com", "1qaz!QAZ");
        UsersAccountPage usersAccountPage = new UsersAccountPage(driver);

        Assertions.assertEquals("MY ACCOUNT", driver.
                findElement(By.xpath("//div[@id='center_column']/h1")).getText());
    }
}
