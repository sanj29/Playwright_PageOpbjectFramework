package com.playwright.automation.pages.diploma;

import com.microsoft.playwright.Page;

public class ConnectWithUsForCinemaProgram {

    Page page;

    public ConnectWithUsForCinemaProgram(Page page){
        this.page=page;
    }

    public  String fileEnquiryForm(){
        page.getByPlaceholder("Full Name").fill("Test User Automation");
        page.getByPlaceholder("Email Address").fill("automation@gmail.com");
        page.getByPlaceholder("Mobile (10 Digits)*").fill("1234567890");
        page.locator("#txtEduCon").selectOption("3");
        page.locator("#txtStateCon").selectOption("2");
        page.locator("#txtCityCon").selectOption("Chittoor");
        page.locator("#txtSchoolCon").selectOption("2");
        page.locator("#txtProgramCon").selectOption("B.A. in Journalism & Mass Communication (Specialization in Sports Journalism) ");
        page.getByPlaceholder("Let us know").click();
        page.getByPlaceholder("Let us know").fill("social media");
        page.locator("input[name=\"whatsapp\"]").check();
        page.locator("div:nth-child(3) > .checkbox-p").click();
        page.locator("div:nth-child(4) > .checkbox-p").click();
        page.locator("input[name=\"rltdinfoyes\"]").check();
        page.locator("input[name=\"rltdinfono\"]").check();
        page.locator(".step-2-bottom-button").click();
/*
        page.waitForPopup(() ->{
            page.locator(".step-2-bottom-button").click();
        });*/

        String optMsg=page.locator("//p[@id='digithide01']").textContent().trim();
        System.out.println(optMsg);
        return optMsg;
    }
}
