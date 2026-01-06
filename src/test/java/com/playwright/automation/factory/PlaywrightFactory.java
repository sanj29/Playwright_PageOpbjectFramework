package com.playwright.automation.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Page initBrowser(Properties prop) {

    String browserName = prop.getProperty("browser", "chromium");
    boolean headless = Boolean.parseBoolean(
            System.getProperty("headless", prop.getProperty("headless", "true"))
    );

    playwright = Playwright.create();

    BrowserType.LaunchOptions options =
            new BrowserType.LaunchOptions().setHeadless(headless);

    switch (browserName.toLowerCase()) {
        case "chrome":
            browser = playwright.chromium()
                    .launch(options.setChannel("chrome"));
            break;
        case "firefox":
            browser = playwright.firefox().launch(options);
            break;
        case "safari":
            browser = playwright.webkit().launch(options);
            break;
        default:
            browser = playwright.chromium().launch(options);
    }

    browserContext = browser.newContext(
            new Browser.NewContextOptions().setViewportSize(1280, 720)
    );

    Page page = browserContext.newPage();
    page.navigate(prop.getProperty("url"));

    PlaywrightDriverManager.setPage(page);
    return page;
}


    // Read properties from config file
    public Properties initProp() {

        prop = new Properties();
        try (FileInputStream fip =
                     new FileInputStream("./src/test/resources/config/config.properties")) {

            prop.load(fip);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }

        return prop;
    }
}
