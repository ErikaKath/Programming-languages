package com.co.blassacademy.logica.steps;

import com.co.blassacademy.logica.models.ClsProducto;
import com.co.blassacademy.logica.utils.ClsConstantesGlobales;
import com.poiji.bind.Poiji;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public class ClsProductoStep {
    public static List<ClsProducto>leerListaProducto(){
        //Con la Libreria Poiji se entrega parametros del excelpath y la clase modelo

        return Poiji.fromExcel(new File(ClsConstantesGlobales.excelPath),ClsProducto.class);
    }

    public static List<ClsProducto>obtenerListaOrdenada(){
        return ClsProductoStep
                .leerListaProducto()
                .stream()
                .sorted(Comparator.comparing(ClsProducto::getName))
                .toList();

    }
    public static ClsProducto obtenerproducto(String name){
        return ClsProductoStep
                .leerListaProducto()
                .stream()
                .filter(o ->o.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }
}
