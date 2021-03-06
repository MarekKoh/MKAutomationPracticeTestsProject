package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class RegisterTest extends BaseTest {

    @Test
    void shouldRegisterUserWhenMandatoryFieldsAreFilled() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver, wait);
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.registerUser(randomUser);

        Assertions.assertTrue(loginPage.isUserLoggedIn());
    }

    @Test
    void shouldDisplayCorrectAlertsWhenPasswordIsMissing() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver, wait);
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

        RegisterPage registerPage = new RegisterPage(driver, wait);
        randomUser.password = "";
        registerPage.registerUser(randomUser);

        Assertions.assertTrue(registerPage.isAlertDisplayed("passwd is required."));
    }
}
