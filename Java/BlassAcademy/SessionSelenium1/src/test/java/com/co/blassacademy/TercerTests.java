package com.co.blassacademy;

import com.co.blassacademy.logica.models.ClsProducto;
import com.co.blassacademy.logica.steps.ClsProductoStep;
import com.co.blassacademy.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TercerTests extends BaseTest {

    private ClsProducto clsProducto;

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        clsProducto = ClsProductoStep.obtenerproducto("AVENA");

    }

    @Test
    public void testName1() {
        //System.out.printf("El precio total es: %.2f ", clsProducto.obtenerTotal());
        Assert.assertTrue(clsProducto.obtenerTotal()>1000);
    }

    @Test
    public void testName2() {

        //System.out.printf("Es perecible? %b", clsProducto.isPerecible());
        Assert.assertFalse(clsProducto.isPerecible());
    }

    @Test
    public void testName3() {
        //System.out.printf("El volumen es: %b ", clsProducto.getVolume());
        Assert.assertTrue(clsProducto.getVolume()>1.7);
    }

    @Test
    public void testBloque() {
        Assert.assertEquals(clsProducto.getName(), "AVENA");
        Assert.assertEquals(clsProducto.getStock(),99);
        Assert.assertFalse(clsProducto.isPerecible());
        Assert.assertTrue(clsProducto.getPrice()>10);
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown() {

    }
}
