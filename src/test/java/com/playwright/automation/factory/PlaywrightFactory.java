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

        System.out.println("Browser name is: " + browserName);
        System.out.println("Headless mode: " + headless);

        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions =
                new BrowserType.LaunchOptions().setHeadless(headless);

        switch (browserName.toLowerCase()) {

            case "chrome":
                browser = playwright.chromium()
                        .launch(launchOptions.setChannel("chrome"));
                break;

            case "chromium":
                browser = playwright.chromium().launch(launchOptions);
                break;

            case "firefox":
                browser = playwright.firefox().launch(launchOptions);
                break;

            case "safari":
                browser = playwright.webkit().launch(launchOptions);
                break;

            default:
                throw new RuntimeException(
                        "Unsupported browser: " + browserName
                );
        }

        // ✅ CI-safe viewport (NO java.awt)
        Browser.NewContextOptions contextOptions =
                new Browser.NewContextOptions()
                        .setViewportSize(1280, 720);

        browserContext = browser.newContext(contextOptions);
        page = browserContext.newPage();

        page.navigate(prop.getProperty("url"));

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
