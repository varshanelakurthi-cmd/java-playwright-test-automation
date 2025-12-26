package com.yourname.automation.tests;
import com.microsoft.playwright.*;
public class BrowserCheck {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page page = browser.newPage();
            page.navigate("https://google.com");

            System.out.println("Browser launched successfully");

            browser.close();
        }
    }
}
