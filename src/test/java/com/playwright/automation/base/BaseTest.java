package com.playwright.automation.base;

import com.microsoft.playwright.Page;
import com.playwright.automation.factory.PlaywrightFactory;
import com.playwright.automation.pages.AAFTHomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
   protected AAFTHomePage homePage;
   protected Properties prop;

    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        prop = pf.initProp();
        page =pf.initBrowser(prop);
        homePage = new AAFTHomePage(page);
        homePage.acceptCookeies();
    }

    @AfterClass
    public  void tearDown(){
        page.context().browser().close();
    }

    @AfterMethod
    public void resetToHome(){
        page.navigate("https://aaft.com/");
    }
}
