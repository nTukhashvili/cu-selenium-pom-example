package Tests;

import Commons.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Test
    public  void loginValid() {
        driver.get("https://www.saucedemo.com");
        LoginPage loginP = new LoginPage(driver);
        loginP.enterUsername("standard_user");
        loginP.enterPassword("secret_sauce");
        loginP.clickOnLogin();
        Assert.assertTrue(loginP.isLoginSuccesful());
    }

    @Test
    public  void loginInvalid() {
        driver.get("https://www.saucedemo.com");
        LoginPage loginP = new LoginPage(driver);
        loginP.enterUsername("standard_user");
        loginP.enterPassword("incorrect");
        loginP.clickOnLogin();
        Assert.assertTrue(loginP.isLoginSuccesful());
    }

}
