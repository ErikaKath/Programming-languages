package com.co.blassacademy.automation;

import com.co.blassacademy.logica.utils.Logs;
import com.co.blassacademy.userinterfaces.LoginPage;
import com.co.blassacademy.utils.Controller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends Controller {

    private final LoginPage loginPage = new LoginPage();
    @BeforeMethod
    public void setUp() {
        Logs.info("surf the page");
        driver.get("https://www.saucedemo.com/v1/");
    }

    @Test
    public void testMistake() {
        loginPage.fillOutForm("locked_out_user", "secret_sauce");
        loginPage.mistakeWarning("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testCheckingPage() {
        loginPage.verifyPage();
    }
}
