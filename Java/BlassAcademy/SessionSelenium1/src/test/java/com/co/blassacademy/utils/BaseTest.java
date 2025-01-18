package com.co.blassacademy.utils;

import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        softAssert= new SoftAssert();
    }
}
