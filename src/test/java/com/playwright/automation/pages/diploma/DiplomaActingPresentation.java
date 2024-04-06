package com.playwright.automation.pages.diploma;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.playwright.automation.constant.AppConstant;
import org.testng.Assert;

import java.nio.file.Paths;

public class DiplomaActingPresentation {

    Page page;

    public DiplomaActingPresentation(Page page){
        this.page =page;
        System.out.println(page.title());
        Assert.assertTrue(page.title().equals(AppConstant.ACTING_PRESENTATION));
    }

    private String applyNow = "//div/button[text()='Apply Now']";
    private String downloadBrochure = "//div/button[text()='Apply Now']/../button[2]";

    public ConnectWithUsForCinemaProgram applyNow(){
        page.locator(applyNow).click();
        page.waitForLoadState();
        return new ConnectWithUsForCinemaProgram(page);

    }
    public  DownloadBrochure clickdownloadBrochure(){
        page.locator(downloadBrochure).click();
        return  new DownloadBrochure(page);
    }

}
