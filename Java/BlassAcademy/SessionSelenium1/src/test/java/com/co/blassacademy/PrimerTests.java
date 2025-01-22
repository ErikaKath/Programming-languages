package com.co.blassacademy;

import com.co.blassacademy.logica.models.ClsMostruo;
import com.co.blassacademy.logica.steps.ClsMostruoStep;
import com.co.blassacademy.utils.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PrimerTests extends Base {

    private List<ClsMostruo>listMostruo;
    SoftAssert softAssert = new SoftAssert();

    @Override
    public void verifyPage() {

    }

    @BeforeMethod
    public void setUp() {
        listMostruo = ClsMostruoStep.leerListaMostruo();

    }

    @Test
    public void testExcelMoustruo() {
        final var moustruo = listMostruo.get(0);
        System.out.println("El nombre del primer moustruo es: " +moustruo.getName());
        Assert.assertEquals(moustruo.getName(), "TOLOSA");
    }

    @Test
    public void testExcelMoustruo1() {
        final int countlist = listMostruo.size();
        System.out.println("El tamaño de la lista es: " +countlist);
        Assert.assertEquals(countlist, 14);
    }

    @Test
    public void testExcelMoustruo2() {
        final var moustruo = listMostruo.get(2);
        System.out.printf("El nivel del tercer moustruo es: %d", moustruo.getLevel());
        Assert.assertEquals(moustruo.getLevel(), 22);
    }

    @Test
    public void testBloque() {
        final  var ultimoMostruo = listMostruo.get(listMostruo.size()-1);


        System.out.println("El ultimo dato es: " +ultimoMostruo);
        System.out.printf("El nombre es: %s" ,ultimoMostruo.getName());

        softAssert.assertEquals(ultimoMostruo.getName(), "LUCENA");
        softAssert.assertEquals(ultimoMostruo.getAge(), 3);
        softAssert.assertEquals(ultimoMostruo.getWeight(), 8.57);
        softAssert.assertAll();//aca termina el bloque

    }

    @AfterMethod
    public void tearDown() {

    }
}
