package com.playwright.automation.factory;

import com.microsoft.playwright.Page;

public class PlaywrightDriverManager {

    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    public static Page getPage() {
        return pageThreadLocal.get();
    }

    public static void setPage(Page page) {
        pageThreadLocal.set(page);
    }

    public static void unload() {
        pageThreadLocal.remove();
    }
}
