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
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.goToUsersAccountPage("abcd@gmail.com", "1qaz!QAZ");
        UsersAccountPage usersAccountPage = new UsersAccountPage(driver, wait);

        Assertions.assertTrue(usersAccountPage.
                isMyAccountHeaderDisplayed("MY ACCOUNT"));
    }
    @Test
    void shouldNotToLogInWithWrongPass() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.goToUsersAccountPage("abcd@gmail.com", "01010101");
        Assertions.assertTrue(loginPage.isAuthenticationFailedAlertDisplayed());
    }
    @Test
    void shouldLogOut() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.goToUsersAccountPage("abcd@gmail.com", "1qaz!QAZ");
        UsersAccountPage usersAccountPage = new UsersAccountPage(driver, wait);
        usersAccountPage.signUserOut();

        Assertions.assertTrue(loginPage.isUserLoggedOut());
    }
    @Test
    void shouldRetrievePassword(){
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.retrieveForgottenPassword("abcd@gmail.com");

        Assertions.assertTrue(loginPage.
                isAlertConfirmationEmailDisplayed());
    }
}
