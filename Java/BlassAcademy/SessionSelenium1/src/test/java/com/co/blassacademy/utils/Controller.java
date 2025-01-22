package com.co.blassacademy.utils;

import com.co.blassacademy.logica.utils.Logs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public  class Controller {
protected WebDriver driver;
    @BeforeMethod
    public void masterSetUp() {
        //inicializar el driver
        Logs.debug("Open webdriver");
        driver = new ChromeDriver();

        Logs.debug("maximize webdriver");
        driver.manage().window().maximize();

        Logs.debug("Remove cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("use implicit wait");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        new WebDriverProvider().set(driver);
    }

    @AfterMethod
    public void masterTearDown() {
        // finalizar el driver
        Logs.debug("Quit webdriver");
        driver.quit();
    }
}
