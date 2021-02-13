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
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        RandomUser randomUser = new RandomUser();
        homePage.subscribeToNewsletter(randomUser.email);
        Assertions.assertTrue(homePage.isNewsletterAlertDisplayed("Newsletter : You have successfully subscribed to this newsletter."));

    }
}
