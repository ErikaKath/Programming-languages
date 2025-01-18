package com.co.mensajesapp.logica.utils;

import org.apache.commons.io.output.TeeOutputStream;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClsArchivoLog {
    public static void crearArchivoTxt_LOG() {

        try {
            DateFormat dateFormat = new SimpleDateFormat("EEE d MMM yyyy HH-mm");
            DateFormat dateFormat2 = new SimpleDateFormat("EEE d MMM yyyy HH-mm-ss");
            String date = dateFormat.format(new Date());
            String date2 = dateFormat2.format(new Date());
            System.out.println("Inicio Ejecución: " + date2);
            FileWriter fichero = new FileWriter("E://Archivos Apoyo//Archivos mensajes_app//LOG//General Info " +date+ ".txt");
            ClsConstantesGlobales.nombreArchivoLog = "E://Archivos Apoyo//Archivos mensajes_app//LOG//Mensajes Log " + date+ ".txt";
            System.out.println("Log situado en: " + ClsConstantesGlobales.nombreArchivoLog);
            fichero.write("Ejecución : " + date);
            fichero.close();
            System.out.println("Inicio Ejecución: " + date2);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al crear el archivo MASIVO txt");
            e.printStackTrace();
        }
    }

    public static void iniciarRegistro() throws IOException {
        File file = new File(ClsConstantesGlobales.nombreArchivoLog);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        // Crear un duplicado de la salida estándar (System.out)
        PrintStream consoleStream = System.out;
        // Redirigir la salida estándar al archivo
        PrintStream fileStream = new PrintStream(fileOutputStream);
        System.setOut(new PrintStream(new TeeOutputStream(consoleStream, fileStream)));
    }
}
