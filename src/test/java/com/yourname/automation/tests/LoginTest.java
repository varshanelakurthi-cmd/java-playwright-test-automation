package com.yourname.automation.tests;

import com.yourname.automation.base.BaseTest;
import com.yourname.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage lp = new LoginPage(page);
        lp.navigate();
        lp.login("standard_user", "secret_sauce");

        page.waitForURL("**/inventory.html");
        Assert.assertTrue(page.url().contains("inventory"));
    }
}
