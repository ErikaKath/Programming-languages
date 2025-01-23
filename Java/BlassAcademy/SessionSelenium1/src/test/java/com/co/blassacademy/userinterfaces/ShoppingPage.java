package com.co.blassacademy.userinterfaces;

import com.co.blassacademy.logica.utils.Logs;
import com.co.blassacademy.models.Clsitems;
import com.co.blassacademy.utils.Base;
import com.co.blassacademy.utils.ClsExcelReader;
import com.co.blassacademy.utils.Controller;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class ShoppingPage extends Base {

    private final By title = By.xpath("//*[text()='Products']");
    private final By itemSelect = By.xpath("//*[@class='product_sort_container']");
    private final By itemList = By.className("inventory_item");
    private final By  inventoryName = By.className("inventory_item_name");
    private final By inventoryPrice = By.className("inventory_item_price");

    @Override
    public void verifyPage() {

        final var softAssert = new SoftAssert();
        Logs.info("checking the ui shopping");
        softAssert.assertTrue(find(title).isDisplayed());
        softAssert.assertTrue(find(itemSelect).isDisplayed());
        softAssert.assertEquals(findAll(itemList).size(),6    );
        softAssert.assertAll();

    }

    public void itemsTest(List<Clsitems> list){
        final var softAssert = new SoftAssert();

        final var listaNombres = findAll(inventoryName);
        final var listaPrecios = findAll(inventoryPrice);

        Logs.info("Enter of list products: %s", list);
        final var n = list.size();
        for(int i =0; i<n; i++){
            final var item = list.get(0);
            final var nombre = listaNombres.get(i).getText();
            final var precio = listaPrecios.get(i).getText();
            softAssert.assertEquals(item.getName(),nombre);
            //Retirar el simbolo pesos $ y convertir de  string a double "$20.99" -> "20.99" -> 20.99
            final var precioSinDolar = Double.parseDouble(precio.replace("$", ""));
            softAssert.assertEquals(item.getPrice(),precioSinDolar);
        }

        softAssert.assertAll();

    }
}
