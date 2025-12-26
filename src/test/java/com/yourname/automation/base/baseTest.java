package com.yourname.automation.base;

import com.microsoft.playwright.*;
import com.yourname.automation.pages.LoginPage;
import com.yourname.automation.utils.configReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public class baseTest {

    protected Playwright playwright;
    protected  Browser browser;
    protected BrowserContext context;
    protected  Page page;

    @BeforeMethod
    public void setUp()
    {
        playwright = Playwright.create();
       String  browserName= configReader.get("browser");
       Boolean headless = Boolean.parseBoolean(configReader.get("headless"));
       BrowserType.LaunchOptions options = new
               BrowserType.LaunchOptions().setHeadless(headless);
        LoginPage lp= new LoginPage(page);
       switch(browserName.toLowerCase())
       {
           case "fifox":
               browser = playwright.firefox().launch(options);
               break;
           case "webkit":
               browser = playwright.webkit().launch(options);
               break;
           default:
            browser = playwright.chromium().launch(options);
            break;
       }

       context= browser.newContext(new Browser.NewContextOptions().
               setStorageStatePath(Paths.get("auth.json")));


       page=context.newPage();
       page.navigate(configReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown()
    {
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
