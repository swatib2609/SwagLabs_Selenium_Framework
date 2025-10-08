package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    By productName = By.xpath("//div[text()='Sauce Labs Backpack']");
    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
