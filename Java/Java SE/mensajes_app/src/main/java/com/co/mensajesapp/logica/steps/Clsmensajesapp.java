package com.co.mensajesapp.logica.steps;

import com.co.mensajesapp.logica.database.ConnectionDataBase;
import com.co.mensajesapp.logica.utils.ClsConstantesGlobales;

import java.sql.SQLException;

public class Clsmensajesapp {
    public static void abrirconnectionBD(){
        System.out.println("Abrir consumir datos a BD");
        ClsConstantesGlobales.consultaSqlQueryMensajes();
        ConnectionDataBase.consumirDatos(ClsConstantesGlobales.sqlQueryMensajes);


    }
}
