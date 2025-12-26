package com.yourname.automation.tests;
import com.microsoft.playwright.*;
import com.yourname.automation.pages.LoginPage;
import com.yourname.automation.base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends baseTest {

    @Test
    public void inventoryPageTest() {
        LoginPage lp = new LoginPage(page);

        lp.navigate();
        lp.login("standard_user", "secret_sauce");

        page.waitForURL("**/inventory.html");
        Assert.assertTrue(page.title().contains("Swag Labs"));
    }
}
