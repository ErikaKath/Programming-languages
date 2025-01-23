package com.co.blassacademy.automation;

import com.co.blassacademy.logica.utils.Logs;
import com.co.blassacademy.userinterfaces.LoginPage;
import com.co.blassacademy.userinterfaces.ShoppingPage;
import com.co.blassacademy.utils.ClsDataGiver;
import com.co.blassacademy.utils.ClsExcelReader;
import com.co.blassacademy.utils.Controller;
import org.openqa.selenium.bidi.log.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingTests extends Controller {

    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    @BeforeMethod
    public void setUp() {
        final var credencialesValidas = ClsDataGiver.obetenerCredencialesValidas();
        Logs.info("surf the page");
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.fillOutForm(credencialesValidas.getUsername(), credencialesValidas.getPassword());
    }

    @Test
    public void testVerifyShopping() {
        shoppingPage.verifyPage();
    }

    @Test
    public void verifyItemsTest(){
        final var listaItems = ClsExcelReader.obtenerListaItem();
        Logs.info("Verificando lista de nombres y precios");
        shoppingPage.itemsTest(listaItems);
    }
}
