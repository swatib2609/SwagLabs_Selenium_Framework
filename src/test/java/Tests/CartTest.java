package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductsPage;

public class CartTest extends BaseTest {
    @Test
    public void verifyCartEmpty() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.openCart();

        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        Assert.assertTrue(items.isEmpty(), "Cart is not empty!");
        test.pass("Cart verified as empty");
    }
}
