package com.varsha.automation.utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;

import java.nio.file.Paths;
import java.util.Map;

public class ApiLoginUtil {

    public static void loginAndSaveAuth(Playwright playwright)
    {
        // 1️⃣ Create API request context (NO browser)
        APIRequestContext request=playwright.request().newContext();

        request.post("https://www.saucedemo.com/api/login",
                RequestOptions.create().setData(Map.of(
                        "username","standard_user",
                       "password","secret_user" )));

        Browser browser=playwright.chromium().launch();
        BrowserContext context= browser.newContext();

        context.storageState(new BrowserContext.StorageStateOptions().
                setPath(Paths.get("auth.json")));

        browser.close();
        request.dispose();


    }
}
