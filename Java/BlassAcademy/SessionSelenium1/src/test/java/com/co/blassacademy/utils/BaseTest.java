package com.co.blassacademy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.List;

public abstract class BaseTest {

    protected WebElement find(By locator){
        return new WebDriverProvider().get().findElement(locator);
    }
    protected List<WebElement> findAll(By locator){
        return new WebDriverProvider().get().findElements(locator);
    }

    public abstract void verifyPage();
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        softAssert= new SoftAssert();
    }
}
