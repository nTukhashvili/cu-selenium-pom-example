package Pages;


import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    // WebElements Locators
    private final By usernameLocator = By.id("user-name");
    private final By passwordLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By loginErrorMessage = By.xpath("//*[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isLoginSuccesful(){
        try{
            WebElement errorMessage = driver.findElement(loginErrorMessage);
            System.out.println(errorMessage.isDisplayed());
            return errorMessage.isDisplayed();
        }
        catch (NoSuchElementException e){
            return true;
        }

    }

    // Actions
    public void enterUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameLocator);
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordLocator);
        passwordElement.sendKeys(password);
    }

    public void clickOnLogin() {
        driver.findElement(loginButtonLocator).click();
    }

    public StorePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickOnLogin();
        return new StorePage(driver);
    }
}
