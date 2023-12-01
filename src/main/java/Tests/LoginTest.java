package Tests;

import Commons.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public  void loginValid() {
        logger.info("Running Test 1");
        driver.get("https://www.saucedemo.com");
        LoginPage loginP = new LoginPage(driver);
        loginP.enterUsername("standard_user");
        loginP.enterPassword("secret_sauce");
        loginP.clickOnLogin();
        Assert.assertTrue(loginP.isLoginSuccesful());
    }

    @Test
    public  void loginInvalid() {
        logger.warn("WARNING WARNING");
        driver.get("https://www.saucedemo.com");
        LoginPage loginP = new LoginPage(driver);
        loginP.enterUsername("standard_user");
        loginP.enterPassword("incorrect");
        loginP.clickOnLogin();
        Assert.assertTrue(loginP.isLoginSuccesful());
    }

}
