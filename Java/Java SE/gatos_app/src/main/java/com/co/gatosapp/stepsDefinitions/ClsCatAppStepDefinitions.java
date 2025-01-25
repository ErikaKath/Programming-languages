package com.co.gatosapp.stepsDefinitions;

import com.co.gatosapp.logica.models.ClsCat;
import com.co.gatosapp.logica.steps.ClsCatServices;

import javax.swing.*;
import java.io.IOException;

/***
 * Esta clase contiene los steps definitions del paso a desarrollar
 * Proyecto Java SE Persistencia de Datos (Bogota-Colombia)
 * Erika Olivera
 * @version 1.0 23/01/2025
 */
public class ClsCatAppStepDefinitions {
    public static void run() throws IOException {
        //Declaración de variables
        int opcion_menu = -1;
        String[] botones = {
                "1. Ver Gatos",
                "2. Ver favoritos",
                "3. Salir"
        };
        do{
            //Menu principal
            String op = (String) JOptionPane.showInputDialog(null, "Gatitos Java",
                    "Menu principal", JOptionPane.INFORMATION_MESSAGE, null, botones,botones[0]);
            //Validamos que opcion selecciona el usuario
            for(int i =0; i< botones.length; i ++){
                if(op.equals(botones[i])){
                    opcion_menu = i;
                }
            }
            switch (opcion_menu){
                case 0:
                    ClsCatServices.seeCat();
                    break;
                case 1:
                    ClsCat gato = new ClsCat();
                    ClsCatServices.seeFavority(gato.getApiKey());
                default:
                    break;
            }

        }while (opcion_menu != 1);

    }
}

