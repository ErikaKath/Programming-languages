package com.co.blassacademy;

import com.co.blassacademy.logica.utils.Logs;

public class EjercicioLogs {
    public static void main(String[] args) {
        //Descripción general
        Logs.info("Soy un paso generico");
        //Descripción puntual
        Logs.debug("Soy un paso debugging, el valor 5");
        //Descripción detallada
        Logs.trace("Soy un paso puntual, el valor es 5 y la lista total es [1. 2. 3. 4. 5. ..");
    }
}
