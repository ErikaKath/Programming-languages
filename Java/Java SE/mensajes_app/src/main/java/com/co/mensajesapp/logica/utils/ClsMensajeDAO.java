package com.co.mensajesapp.logica.utils;

import com.co.mensajesapp.logica.database.ConnectionDataBase;
import com.co.mensajesapp.logica.models.ClsMensajes;

import java.sql.PreparedStatement;

public class ClsMensajeDAO {
    public static void crearMensajeDB(ClsMensajes mensaje){
        PreparedStatement ps = null;
        try{
            ConnectionDataBase.consumirDatos(ClsConstantesGlobales.sqlQueryMensajes);
        }catch (Exception e){
            System.out.println(e);

        }


    }
    public static void listarMensajeDB(){

    }
    public static void borrarMensajeDB(){

    }
    public static void editarMensajeDB(){

    }
}
