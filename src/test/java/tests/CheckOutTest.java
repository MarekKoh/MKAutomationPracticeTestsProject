package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;

public class CheckOutTest extends BaseTest {

    @Test
    public void shouldCheckout(){
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.goToUsersAccountPage("abcd@gmail.com", "1qaz!QAZ");
        UsersAccountPage usersAccountPage = new UsersAccountPage(driver, wait);
        usersAccountPage.goToShoppingPage();
        ShoppingPage shoppingPage = new ShoppingPage(driver, wait);
        shoppingPage.addRandomProductsToTheCart(2);
        CheckOutPage checkOutPage = new CheckOutPage(driver, wait);
        checkOutPage.finaliseThePurchaseOrder();
        Assertions.assertTrue(checkOutPage.isOrderConfirmationAlertDisplayed());
    }
}
