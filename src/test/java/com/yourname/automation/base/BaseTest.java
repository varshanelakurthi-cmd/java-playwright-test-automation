package com.yourname.automation.base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {

        // 1️⃣ Start Playwright engine
        playwright = Playwright.create();

        // 2️⃣ Launch browser (headless = true for CI)
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
        );

        // 3️⃣ Create a fresh browser context (clean session)
        context = browser.newContext();

        // 4️⃣ Create a new page (browser tab)
        page = context.newPage();
    }

    @AfterMethod
    public void tearDown() {

        // 5️⃣ Close everything after each test
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
