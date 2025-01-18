package com.co.blassacademy.logica.steps;

import com.co.blassacademy.logica.models.ClsProducto;
import com.co.blassacademy.logica.models.ClsVideoJuego;
import com.co.blassacademy.logica.utils.ClsConstantesGlobales;
import com.poiji.bind.Poiji;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public class ClsVideoJuegoStep {

    public static List<ClsVideoJuego>leerVideoJuego(){
        //Con la Libreria Poiji se entrega parametros del excelpath y la clase modelo
        return Poiji.fromExcel(new File(ClsConstantesGlobales.excelPath), ClsVideoJuego.class);
    }
    public static List<ClsVideoJuego> obtenerVideoJuego(String name){
        return ClsVideoJuegoStep
                .leerVideoJuego()
                .stream()
                .sorted(Comparator.comparing(ClsVideoJuego::getName))
                .toList();
    }
}
