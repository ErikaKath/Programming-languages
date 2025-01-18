package com.co.blassacademy.stepsDefinitions;

import com.co.blassacademy.logica.models.ClsMostruo;
import com.co.blassacademy.logica.models.ClsProducto;
import com.co.blassacademy.logica.steps.ClsMostruoStep;
import com.co.blassacademy.logica.steps.ClsProductoStep;
import com.co.blassacademy.logica.steps.ClsVideoJuegoStep;
import com.co.blassacademy.logica.utils.ClsExcelArchivo;
import com.co.blassacademy.logica.utils.Logs;

import java.util.Comparator;

public class ClsExcelStepsDefinitions {

    public static void run(){
        //Leer Excel
//        final var listaProducto = ClsProductoStep.
//                leerListaProducto()
//                .stream()
//                //Filtrar los elemetos mayores a 72
//                .filter(o -> o.getStock()>72)
//                //Mostrar por consola
//                .toList();
//        Logs.debug("Lista: %s", listaProducto);
//        System.out.println(listaProducto);
//        final var avena = ClsProductoStep
//                .leerListaProducto()
//                .stream()
//                .filter(o->o.getName().equals("AVENA"))
//                .findFirst()
//                .orElseThrow();
        final var avena = ClsProductoStep.obtenerproducto("AVENA");
        final var precioTotal = avena.obtenerTotal();
        System.out.printf("Precio Total: %.2f%n ", precioTotal);

//        final var listaMostruo = ClsMostruoStep
//                .leerListaMostruo()
//                .stream()
//                //Ordenar de mayor a menosr nivel
//                .sorted(Comparator.comparingInt(ClsMostruo::getLevel).reversed())
//                .toList();
//        System.out.println(listaMostruo);
//
//        final var listaVideoJuego = ClsVideoJuegoStep
//                .leerVideoJuego()
//                .stream()
//                .filter(o->o.getDuration()>50)
//                .toList();
//        System.out.println(listaVideoJuego);
//        final var listaVideoJuegoH = ClsVideoJuegoStep
//                .leerVideoJuego()
//                .stream()
//                .filter(o -> o.getName().startsWith("A"))
//                .toList();
//        System.out.println(listaVideoJuegoH);
//        final var listarDeAz = ClsProductoStep.obtenerListaOrdenada();
//        System.out.println(listarDeAz);




    }

}
