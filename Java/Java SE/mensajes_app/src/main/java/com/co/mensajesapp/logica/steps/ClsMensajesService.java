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
        //Crear el objeto scaneer
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido");
        //Scanner para captar el ID
        System.out.println("Indica el ID del mensaje a borrar: ");
        int ID_MENSAJE = sc.nextInt();
        //Enviar parametro captado del ID
        ClsMensajeDAO.borrarMensajeDB(ID_MENSAJE);

    }
    public static void editarMensaje(){
        //Crear el objeto scaneer
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido");
        //Scanner para captar el mensaje
        System.out.println("Escribe tu mensaje a editar: ");
        String mensaje = sc.nextLine();
        //Scanner para captar el id del mensaje a editar
        System.out.println("Indica el ID del mensaje: ");
        int ID_MENSAJE = sc.nextInt();

        ClsMensajes actualizacion = new ClsMensajes();
        actualizacion.setMENSAJE(mensaje);
        actualizacion.setID_MENSAJE(ID_MENSAJE);
        ClsMensajeDAO.editarMensajeDB(actualizacion);

    }
}
