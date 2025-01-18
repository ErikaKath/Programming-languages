package com.co.blassacademy;

import com.co.blassacademy.logica.models.ClsProducto;
import com.co.blassacademy.logica.models.ClsVideoJuego;
import com.co.blassacademy.logica.steps.ClsProductoStep;
import com.co.blassacademy.logica.steps.ClsVideoJuegoStep;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SegundoTests  {

    private List<ClsVideoJuego>videoJuegoList;

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        videoJuegoList = ClsVideoJuegoStep.leerVideoJuego();
        //System.out.println("La lista ordenada es: " + productoList);

    }

    @Test
    public void testName() {
        final var videoJuego = videoJuegoList.get(0);
        Assert.assertEquals(videoJuego.getName(), "ASSASSIN'S CREED VALHALLA");
        //System.out.printf("El nombre del primer elementos es: %s", producto.getName());
    }

    @Test
    public void testExcelProduct() {
//        final var producto = productoList.get((productoList.size()-1));
//        System.out.printf("El nombre del ultimo elementos es: %s", producto.getName());
//        final var finallyVideoJuego = videoJuegoList.get((videoJuegoList.size()-1));
//        Assert.assertEquals(finallyVideoJuego.getName(), "VALHEIM");
    }

    @Test
    public void testBloque(){
        final var finallyVideoJuego = videoJuegoList.get((videoJuegoList.size()-1));
        Assert.assertEquals(finallyVideoJuego.getName(), "VALHEIM");
        Assert.assertEquals(finallyVideoJuego.getGender(), "COMEDIA");
        Assert.assertEquals(finallyVideoJuego.getAge(),2013);
        softAssert.assertAll();

    }
}
