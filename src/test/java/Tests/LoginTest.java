package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utility.ExcelUtils;

public class LoginTest extends BaseTest {
    @Test
    public void validLogin() throws Exception {
        String username = ExcelUtils.getCellValue("./data/LoginData.xlsx", "Sheet1", 0, 0);
        String password = ExcelUtils.getCellValue("./data/LoginData.xlsx", "Sheet1", 0, 1);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed");
        test.pass("Login successful");
    }
}
