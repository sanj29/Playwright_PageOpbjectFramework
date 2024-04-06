package com.playwright.automation.pages;

import com.microsoft.playwright.Page;

public class AAFTHomePage {

    // String locators

    Page page;

    private String programs ="//a[text()='Programs']";
    private  String searchTxtBox ="div#search input";
    private String searchIcon ="div#search button";
    private String searchHeader = "div#content h1";

    private  String acceptCookeies ="#ccbar_okbutton";

    //page constructor

    public AAFTHomePage(Page page){
        this.page=page;
    }

    // page methods

    public ProgramsPage goToProgramPage(){
        page.locator(programs).click();
        return  new ProgramsPage(page);
    }
    public String getHomePageTitle(){
        String title =page.title();
        System.out.println("Page title is : " +title);
        return title;
    }

    public String getHomePageURL(){
        String url =page.url();
        System.out.println("Page url is : " +url);
        return  url;
    }

    public  String doSearch(String productName){
        page.locator(searchTxtBox).fill(productName);
        page.locator(searchIcon).click();
        String name= page.locator(searchHeader).textContent();
        System.out.println(" Searched product ::" +name);
        return name;
    }

    public void acceptCookeies() {
        page.frame("ccbar_iframe").locator(acceptCookeies).click();
        //page.locator(acceptCookeies).click();
    }
}
