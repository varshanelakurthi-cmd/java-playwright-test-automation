package com.yourname.automation.tests;

import com.yourname.automation.base.baseTest;
import com.yourname.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends baseTest {

    @Test
    public void validLoginTest() {
        LoginPage lp = new LoginPage(page);

        lp.navigate();
        lp.login("standard_user", "secret_sauce");

        page.waitForURL("**/inventory.html");
        Assert.assertTrue(page.title().contains("Swag Labs"));
    }

    @Test
    public void inventoryPageTest() {
        LoginPage lp = new LoginPage(page);

        lp.navigate();
        lp.login("standard_user", "secret_sauce");

        page.waitForURL("**/inventory.html");
        Assert.assertTrue(page.url().contains("inventory"));
    }
}
