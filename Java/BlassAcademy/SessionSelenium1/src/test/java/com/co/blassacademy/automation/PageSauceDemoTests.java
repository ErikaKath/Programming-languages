package com.co.blassacademy.automation;

import com.co.blassacademy.logica.utils.Logs;
import com.co.blassacademy.utils.Controller;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSauceDemoTests extends Controller {
    @Test
    public void testNavegarPageSauceDemo() {
        final  var url = "https://www.saucedemo.com/v1/";
        Logs.info("Navegar a la url de SauceDemo");
        driver.get(url);

        Logs.info("Validación de URL");
        final var urlValidacion = driver.getCurrentUrl();
        try{
            Thread.sleep(2500);
            Assert.assertEquals(urlValidacion, url);
        }catch (InterruptedException interruptedException){

        }

    }

    @Test
    public void testNavegarEntrePaginas(){
        final var url1 = "https://demoqa.com/webtables";
        final var url2= "https://www.opencart.com/index.php?route=account/register";

        Logs.info("Navegar a las paginas DemoQA url1");
        driver.get(url1);
        Logs.info("Navegar a las paginas Opencart url2");
        driver.get(url2);
        Logs.info("Regresar a la pagina anterior");
        driver.navigate().back();
        Logs.info("Validar que la url sea la correcta");
        final var urlCurrent = driver.getCurrentUrl();
        try {
            Thread.sleep(2500);
            Assert.assertEquals(urlCurrent,url1);
        }catch (InterruptedException interruptedException){

        }
    }
}
