package com.playwright.automation.base;

import com.microsoft.playwright.Page;
import com.playwright.automation.factory.PlaywrightFactory;
import com.playwright.automation.factory.PlaywrightDriverManager;
import com.playwright.automation.pages.AAFTHomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {

    protected PlaywrightFactory pf;
    protected Properties prop;
    protected AAFTHomePage homePage;

    @BeforeMethod
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.initProp();
        pf.initBrowser(prop);

        Page page = PlaywrightDriverManager.getPage();
        homePage = new AAFTHomePage(page);
        homePage.acceptCookeies(); // safe
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Page page = PlaywrightDriverManager.getPage();
        if (page != null) {
            page.context().browser().close();
            PlaywrightDriverManager.unload();
        }
    }
}
