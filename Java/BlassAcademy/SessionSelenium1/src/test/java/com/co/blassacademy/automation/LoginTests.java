package com.co.blassacademy.automation;

import com.co.blassacademy.logica.utils.Logs;
import com.co.blassacademy.models.ClsCredencial;
import com.co.blassacademy.userinterfaces.LoginPage;
import com.co.blassacademy.utils.ClsDataGiver;
import com.co.blassacademy.utils.Controller;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends Controller {

    private final LoginPage loginPage = new LoginPage();


    @BeforeMethod
    public void setUp() {
        Logs.info("surf the page");
        //driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
    }

    @Test
    public void testMistake() {
        final var credencialBloqueada = ClsDataGiver.obetenerCredencialesBloqueadas();
        loginPage.fillOutForm(credencialBloqueada.getUsername(), credencialBloqueada.getPassword());
        loginPage.mistakeWarning(credencialBloqueada.getMessage());
    }

    @Test
    public void testCheckingPage() {
        loginPage.verifyPage();
    }
}
