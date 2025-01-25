package com.co.gatosapp.runners;

import com.co.gatosapp.stepsDefinitions.ClsCatAppStepDefinitions;

import java.io.IOException;

/***
 * Esta clase contiene el runner para ejecutar la entrada principal del proyecto
 * Proyecto Java SE Persistencia de Datos (Bogota-Colombia)
 * Erika Olivera
 * @version 1.0 23/01/2025
 */
public class ClsCatAppRunner {
    public static void main(String[] args) throws IOException {
        ClsCatAppStepDefinitions.run();
        System.exit(0);

    }
}
