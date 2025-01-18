package com.co.blassacademy.utils;

import com.co.blassacademy.logica.utils.Logs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Controller {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        Logs.debug("Inicializar Controlador WebDriver Chrome");
        driver = new ChromeDriver();

        Logs.debug("Maximizando el driver");
        driver.manage().window().maximize();

        Logs.debug("Borrando cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("Asignando implicit wait");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Logs.debug("Guardando el driver");
        new WebDriverProvider().set(driver);

    }

    @AfterMethod
    public void tearDown() {
        var driver =    new WebDriverProvider().get();
        Logs.debug("Matando el driver");
        driver.quit();

    }
}
