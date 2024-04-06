package com.playwright.automation.pages.diploma;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

import java.nio.file.Paths;

public class DownloadBrochure {

    Page page;
    public DownloadBrochure (Page page){
        this.page=page;
    }


    public String downloadNow ="button.btn.btn-default";
    public  String fullName="#txtNameDow";
    public  String email="#txtEmailDow";
    public  String mobile="#txtPhoneDow";
    public String selectProgram="select[name='programb']";
    public String selectState="#txtStateDow";
    public String selectCity="#txtCityDow";


    public void fileDownloadForm(){
        page.locator(fullName).fill("Test Automated used");
        page.locator(email).fill("testautomation@gmail.com");
        page.locator(mobile).fill("1234567890");
        page.locator(selectProgram).selectOption("Diploma in Cinematography");
        page.locator(selectState).selectOption("34");
        page.locator(selectCity).selectOption("Gautam Buddh Nagar");
    }

    public void downloadNow(){
        fileDownloadForm();
        Download download = page.waitForDownload(() -> {
            page.locator(downloadNow).click();
        });

        download.saveAs(Paths.get("./src/download/Diploma_in_Acting_and_Presentation.pdf"));
    }


    public void verifyAlertForDownload(){
        String alertMsg;
        page.onDialog(dialog -> {
         String  text = dialog.message();
            System.out.println(text);
            dialog.accept("hi welcome to my alert");
            //dialog.dismiss();
        });
        page.click(downloadNow);
    }
}
