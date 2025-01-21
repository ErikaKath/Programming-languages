package com.co.mensajesapp.stepsDefinitions;

import com.co.mensajesapp.logica.database.ConnectionDataBase;
import com.co.mensajesapp.logica.steps.ClsMensajesService;
import com.co.mensajesapp.logica.steps.Clsmensajesapp;
import com.co.mensajesapp.logica.utils.ClsArchivoLog;

import java.util.Scanner;

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
//            //Abrir conexion mensajes app
//            System.out.println("Abrir connection para consumir datos. consultas a la BD");
//            Clsmensajesapp.abrirconnectionBD();
            Scanner sc = new Scanner(System.in);
            int option= 0;
            do{
                System.out.println("---------------");
                System.out.println("Aplicacion de mensajes");
                System.out.println(" 1. Crear Mensaje");
                System.out.println(" 2. Listar Mensaje");
                System.out.println(" 3. Editar Mensaje");
                System.out.println(" 4. Eliminar Mensaje");
                System.out.println(" 5. Salir");
                //Leemos la opcion del usuario
                option = sc.nextInt();

                switch (option){
                    case 1:
                        ClsMensajesService.crearMensaje();
                        break;
                    case 2:
                        ClsMensajesService.listarMensajes();
                        break;
                    case 3:
                        ClsMensajesService.borrarMensaje();
                        break;
                    case 4:
                        ClsMensajesService.editarMensaje();
                        break;
                    default:
                        break;
                }

            }while (option!=5);


//

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
