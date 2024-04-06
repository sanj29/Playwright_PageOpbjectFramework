package com.playwright.automation.tests;

import com.playwright.automation.base.BaseTest;
import com.playwright.automation.pages.ProgramsPage;
import com.playwright.automation.pages.diploma.ConnectWithUsForCinemaProgram;
import com.playwright.automation.pages.diploma.DiplomaActingPresentation;
import com.playwright.automation.pages.diploma.DownloadBrochure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CinemaProgramApplyTest extends BaseTest {

    ProgramsPage programsPage;
    DiplomaActingPresentation diplomaActingPresentation;
    ConnectWithUsForCinemaProgram cp;
    DownloadBrochure db;
    @Test
    public void applyForCinemaProgram(){

        programsPage =homePage.goToProgramPage();
        String text= programsPage.verifyDiplomaProgram();
        Assert.assertEquals(text," Diploma");
        diplomaActingPresentation =programsPage.gotoDiplomaActionPage();
       cp= diplomaActingPresentation.applyNow();
       String optMsg = cp.fileEnquiryForm();
       Assert.assertTrue(optMsg.contains("Enter Verification code we have sent you"));
    }

    @Test
    public  void downloadBrochureTest(){
        programsPage =homePage.goToProgramPage();
        String text= programsPage.verifyDiplomaProgram();
        Assert.assertEquals(text," Diploma");
        diplomaActingPresentation =programsPage.gotoDiplomaActionPage();
        db=diplomaActingPresentation.clickdownloadBrochure();
        db.downloadNow();

    }

    @Test
    public  void downloadBrochureWithoutDataTest(){
        programsPage =homePage.goToProgramPage();
        String text= programsPage.verifyDiplomaProgram();
        Assert.assertEquals(text," Diploma");
        diplomaActingPresentation =programsPage.gotoDiplomaActionPage();
        db=diplomaActingPresentation.clickdownloadBrochure();
        db.verifyAlertForDownload();

    }



}
