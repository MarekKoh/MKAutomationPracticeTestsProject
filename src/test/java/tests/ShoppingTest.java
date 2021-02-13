package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.BasePage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ShoppingPage;

public class ShoppingTest extends BaseTest{

    @Test
    public void addProductsToTheCart() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToShoppingPage();
        ShoppingPage shoppingPage = new ShoppingPage(driver, wait);
        shoppingPage.addRandomProductsToTheCart(2);

        Assertions.assertEquals(2, homePage.getQuantityOfItemsInTheCart());
    }
}
