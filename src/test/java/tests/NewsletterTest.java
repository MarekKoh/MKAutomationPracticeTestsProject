package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.BasePage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class NewsletterTest extends BaseTest {

    @Test
    public void  subscribeNewsletterByValidEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        RandomUser randomUser = new RandomUser();
        homePage.subscribeToNewsletter(randomUser.email);
        BasePage basePage = new BasePage(driver);
        Assertions.assertTrue(basePage.isNewsletterAlertDisplayed("Newsletter : You have successfully subscribed to this newsletter."));
    }
}
