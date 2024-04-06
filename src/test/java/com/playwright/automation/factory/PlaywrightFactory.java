package com.playwright.automation.factory;

import com.microsoft.playwright.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;
    public Page  initBrowser(Properties prop){
        Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)dim.getWidth();
        int height = (int)dim.getHeight();

        String browserName = prop.getProperty("browser");
        System.out.println("Browser name is :" + browserName);

        playwright = Playwright.create();
        boolean headless =false;
        if(prop.getProperty("headless").equals("true"))
            headless =true;

        switch (browserName.toLowerCase()){
            case "chrome":
              browser=  playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));
              break;

            case "chromium":
                browser=  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;

            case "firefox":
                browser=  playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;

            case "safari":
                browser=  playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;

            default:
                System.out.println("Please pass the right browser name .....");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.setViewportSize(width,height);
        page.navigate(prop.getProperty("url"));

        return page;
    }

    // read properties from config file.

    public Properties initProp() {

        try{
            FileInputStream fip =  new FileInputStream("./src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(fip);
        }catch (IOException e){
            e.printStackTrace();
        }

        return prop;
    }
}
