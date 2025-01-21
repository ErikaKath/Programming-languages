package com.co.mensajesapp.logica.utils;

import java.util.ArrayList;
import java.util.Map;

public class ClsConstantesGlobales {
    public static String baseDatosSeleccion;
    public static int sizeConsultQuery2;
    public static ArrayList<Map<String, String>> datosQuery1 = new ArrayList<>();
    public static String nombreArchivoLog = "";



    public static String crearSqlQueryMensajes;
    public static String crearMensajeSqlQueryMensajes(){
        crearSqlQueryMensajes = "INSERT TO mensajes () VALUES(?,?)";
        System.out.println("Consulta SQL generada: " + crearSqlQueryMensajes);
        return crearSqlQueryMensajes;
    }
    public static String sqlQueryMensajes;
    public static String consultaSqlQueryMensajes() {
        sqlQueryMensajes = "SELECT * FROM dbo.mensajes";
        System.out.println("Consulta SQL generada: " + sqlQueryMensajes);
        return sqlQueryMensajes;
    }



}
