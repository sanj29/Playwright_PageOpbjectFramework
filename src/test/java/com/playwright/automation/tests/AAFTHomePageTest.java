package com.playwright.automation.tests;

import com.playwright.automation.base.BaseTest;
import com.playwright.automation.constant.AppConstant;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AAFTHomePageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyURL(){
        String actualURL =homePage.getHomePageURL();
        Assert.assertEquals(actualURL,prop.getProperty("url"));
    }

    @Test(priority = 2)
    public void verifyPageTitle(){
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstant.LOGIN_PAGE_TITLE);
    }

    @Test(dataProvider = "getProductData", priority = 3)
    public void testSearchProduct(String productName){
        String pName = homePage.doSearch(productName);
        Assert.assertTrue(pName.contains(productName));
    }

    @DataProvider
    public Object[][] getProductData(){

        return new Object[][] {
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

}
