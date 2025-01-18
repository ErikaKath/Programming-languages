package com.co.blassacademy.utils;

import org.openqa.selenium.WebDriver;

public class WebDriverProvider {
    private static final ThreadLocal<WebDriver>threadLoal = new ThreadLocal<>();
    public void  set (WebDriver driver){
        threadLoal.set(driver);

    }
    public WebDriver get(){
        return threadLoal.get();
    }
}
