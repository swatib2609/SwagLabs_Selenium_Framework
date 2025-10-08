package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;

public class ProductSelectTest extends BaseTest {
    @Test
    public void addProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemName(), "Sauce Labs Backpack");
        test.pass("Product added and verified in cart");
    }
}
