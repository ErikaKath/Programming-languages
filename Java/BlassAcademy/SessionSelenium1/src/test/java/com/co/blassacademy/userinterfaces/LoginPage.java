package com.co.blassacademy.userinterfaces;

import com.co.blassacademy.logica.utils.Logs;
import com.co.blassacademy.utils.Base;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;



public class LoginPage extends Base {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By button = By.id("login-button");
    private  final By mistakeMessage= By.cssSelector("h3[data-test='error']");
    @Override
    public void verifyPage() {

        Logs.info("Checking of UI the page Login");
        final var softAssert = new SoftAssert();

        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(button).isDisplayed());
        softAssert.assertAll();
    }

    public void fillOutForm(String username, String password) {

        Logs.info("Enter of username: %s", username);
        find(usernameInput).sendKeys(username);
        Logs.info("Enter of password: %s", password);
        find(passwordInput).sendKeys(password);
        Logs.info("Click of button login");
        find(button).click();

    }


    public void mistakeWarning(String texto){

        final var softAssert = new SoftAssert();
        Logs.info("Checking the message of mistake: %s", texto);
        softAssert.assertTrue(find(mistakeMessage).isDisplayed());
        softAssert.assertEquals(find(mistakeMessage).getText(), texto);
        softAssert.assertAll();

    }



}
