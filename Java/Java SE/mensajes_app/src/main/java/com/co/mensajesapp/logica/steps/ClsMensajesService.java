package com.co.mensajesapp.logica.steps;

import com.co.mensajesapp.logica.models.ClsMensajes;
import com.co.mensajesapp.logica.utils.ClsMensajeDAO;

import java.util.Scanner;

public class ClsMensajesService {
    public static void crearMensaje(){
        //Crear el objeto scaneer
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido");
        //Scanner para captar el mensaje
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();
        //Scanner para captar nombre del autor
        System.out.println("Tu nombre es: ");
        String nombre = sc.nextLine();

        ClsMensajes registro = new ClsMensajes();
        registro.setMENSAJE(mensaje);
        registro.setAUTOR_MENSAJE(nombre);
        ClsMensajeDAO.crearMensajeDB(registro);


    }
    public static void listarMensajes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.println("La lista de mensajes es: ");
        ClsMensajeDAO.listarMensajeDB();

    }
    public static void borrarMensaje(){

    }
    public static void editarMensaje(){

    }
}
