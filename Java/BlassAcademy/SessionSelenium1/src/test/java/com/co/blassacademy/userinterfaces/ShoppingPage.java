package com.co.blassacademy.userinterfaces;

import com.co.blassacademy.logica.utils.Logs;
import com.co.blassacademy.utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;


public class ShoppingPage extends BaseTest {

    private final By title = By.xpath("//*[text()='Products']");
    private final By itemSelect = By.xpath("//*[@class='product_sort_container']");
    private final By itemList = By.className("inventory_item");

    @Override
    public void verifyPage() {

        final var softAssert = new SoftAssert();
        Logs.info("checking the ui shopping");
        softAssert.assertTrue(find(title).isDisplayed());
        softAssert.assertTrue(find(itemSelect).isDisplayed());
        softAssert.assertEquals(findAll(itemList).size(),6    );
        softAssert.assertAll();

    }
}
