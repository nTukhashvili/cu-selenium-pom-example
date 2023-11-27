package Tests;

import Commons.BaseTest;
import Pages.LoginPage;
import Pages.StorePage;
import org.testng.annotations.Test;

public class AddToCart  extends BaseTest {

    @Test
    public void checkCart() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        LoginPage loginP = new LoginPage(driver);

        StorePage storeP =  loginP.login("standard_user","secret_sauce");

        storeP.addProductByIndex(3);
        storeP.addProductByIndex(2);
        Thread.sleep(2000);
        storeP.addProductByText("Sauce Labs Backpack");
        Thread.sleep(2000);
        System.out.println(storeP.extractNumberFromElementText());
    }

}
