package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public void openPage(){
        driver.get(BASE_URL);
    }

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goToShoppingPage() {
        driver.get(womenCatPageUrl);
    }

}
