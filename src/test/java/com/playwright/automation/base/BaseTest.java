package com.playwright.automation.base;

import com.microsoft.playwright.Page;
import com.playwright.automation.factory.PlaywrightFactory;
import com.playwright.automation.pages.AAFTHomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {

    protected PlaywrightFactory pf;
    protected Page page;
    protected AAFTHomePage homePage;
    protected Properties prop;

    @BeforeMethod
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.initProp();
        page = pf.initBrowser(prop);

        homePage = new AAFTHomePage(page);
        homePage.acceptCookeies(); // safe & optional
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (page != null) {
            page.context().browser().close();
        }
    }
}
