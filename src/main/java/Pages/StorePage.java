package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StorePage {
    private final WebDriver driver;


    private final By cartItemIndicator = By.xpath("//span[@class='shopping_cart_badge']");
    public StorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductByIndex(int index) {
        String xpathExpression = String.format("//*[@class='inventory_item'][%d]//button", index);
        WebElement productElement = driver.findElement(By.xpath(xpathExpression));
        productElement.click();
    }

    public void addProductByText(String text) {
        String xpathExpression = String.format("//*[contains(text(),'%s')]//ancestor::div[@class='inventory_item']//button", text);
        WebElement productElement = driver.findElement(By.xpath(xpathExpression));
        productElement.click();
    }

    public int extractNumberFromElementText() {
        WebElement element = driver.findElement(cartItemIndicator);
        String elementText = element.getText();

        String numberString = elementText.replaceAll("[^\\d]", "");  // Remove non-digit characters
        return Integer.parseInt(numberString);
    }






}
