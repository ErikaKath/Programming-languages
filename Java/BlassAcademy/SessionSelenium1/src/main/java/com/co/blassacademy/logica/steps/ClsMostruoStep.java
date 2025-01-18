package com.co.blassacademy.logica.steps;

import com.co.blassacademy.logica.models.ClsMostruo;
import com.co.blassacademy.logica.models.ClsProducto;
import com.co.blassacademy.logica.utils.ClsConstantesGlobales;
import com.poiji.bind.Poiji;

import java.io.File;
import java.util.List;

public class ClsMostruoStep {
    public static List<ClsMostruo> leerListaMostruo(){
        //Con la Libreria Poiji se entrega parametros del excelpath y la clase modelo
        return Poiji.fromExcel(new File(ClsConstantesGlobales.excelPath),ClsMostruo.class);
    }
}
