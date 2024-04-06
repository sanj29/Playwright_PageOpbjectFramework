package com.playwright.automation.pages;

import com.microsoft.playwright.Page;
import com.playwright.automation.pages.diploma.DiplomaActingPresentation;

public class ProgramsPage {

    Page page;

    public ProgramsPage(Page page){
        this.page=page;
    }

    private  String underGraduate ="div.sticky-top li:has(a[href='#undergraduate-program1'])";
    private  String postGraduate ="div.sticky-top li:has(a[href='#postgraduate-program1'])";
    private  String diploma ="div.sticky-top li:has(a[href='#diploma-program1'])";
    private  String shortTermProgram ="div.sticky-top li:has(a[href='#short-term-program1'])";
    private  String diplomaActingPresentation = "#diploma-program1 >div a";




    public String verifyUnderGraduateProgram(){
        page.locator(underGraduate).click();
        String ugPro =page.locator(underGraduate).textContent();
        System.out.println(" Program Type :" +ugPro);
        return ugPro;

    }

    public String verifyPostGraduateProgram(){
        page.locator(postGraduate).click();
        String pgPro =page.locator(postGraduate).textContent();
        System.out.println(" Program Type :" +pgPro);
        return pgPro;

    }

    public String verifyDiplomaProgram(){
        page.locator(diploma).click();
        String dipPro =page.locator(diploma).textContent();
        System.out.println(" Program Type :" +dipPro);
        return dipPro;
    }



    public String verifyShortTermProgramProgram(){
        page.locator(shortTermProgram).click();
        String stpPro =page.locator(shortTermProgram).textContent();
        System.out.println(" Program Type :" +stpPro);
        return stpPro;
    }

    public DiplomaActingPresentation gotoDiplomaActionPage(){
        page.locator(diplomaActingPresentation).first().click();
        return  new DiplomaActingPresentation(page);
    }
}
