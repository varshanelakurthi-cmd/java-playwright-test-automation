package com.yourname.automation.tests;
import com.microsoft.playwright.*;
import com.yourname.automation.pages.LoginPage;
import com.yourname.automation.base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends baseTest {

    @Test
    public void inventoryPageTest() {

        page.navigate("https://www.saucedemo.com/inventory.html");

        String title = page.title();
        Assert.assertTrue(title.contains("Swag Labs"));
    }
}
