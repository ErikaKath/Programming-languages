package com.co.mensajesapp.stepsDefinitions;

import com.co.mensajesapp.logica.database.ConnectionDataBase;
import com.co.mensajesapp.logica.steps.Clsmensajesapp;
import com.co.mensajesapp.logica.utils.ClsArchivoLog;

public class ClsMensajesStepDefinitions {
    public static void run(){
        try {
            //Crear archivo Log
            ClsArchivoLog.crearArchivoTxt_LOG();
            //Iniciar registros
            ClsArchivoLog.iniciarRegistro();
            //Conexion a BD nombre mensajes_app
            System.out.println("Connection de BD nombre mensajes_app");
            ConnectionDataBase.connectionDataBase("mensajes_app");
            //Abrir conexion mensajes app
            System.out.println("Abrir connection para consumir datos");
            Clsmensajesapp.abrirconnectionBD();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
