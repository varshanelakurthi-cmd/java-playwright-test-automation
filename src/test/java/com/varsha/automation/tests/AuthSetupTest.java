package com.varsha.automation.tests;

import com.microsoft.playwright.Playwright;
import com.varsha.automation.utils.ApiLoginUtil;
import org.testng.annotations.Test;

public class AuthSetupTest {
    @Test
    public void generateAuthJson() {
        ApiLoginUtil.loginAndSaveAuth(Playwright.create());
    }
}
