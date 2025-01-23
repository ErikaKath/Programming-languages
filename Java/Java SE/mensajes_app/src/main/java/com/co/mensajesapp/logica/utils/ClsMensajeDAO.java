package com.co.mensajesapp.logica.utils;

import com.co.mensajesapp.logica.database.ConnectionDataBase;
import com.co.mensajesapp.logica.models.ClsMensajes;
import com.co.mensajesapp.logica.steps.Clsmensajesapp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClsMensajeDAO {
    public static void crearMensajeDB(ClsMensajes mensaje){
        PreparedStatement ps = null;
        try{
            String query = "INSERT INTO mensajes ( MENSAJE, AUTOR_MENSAJE) VALUES(?,?)";
            ps = ConnectionDataBase.connection.prepareStatement(query);
            ps.setString(1, mensaje.getMENSAJE());
            ps.setString(2, mensaje.getAUTOR_MENSAJE());
            ps.executeUpdate();
            System.out.println("El mensaje creado correctamente");
        }catch (SQLException e){
            System.out.println(e);

        }


    }
    public static void listarMensajeDB(){
        try{
            Clsmensajesapp.abrirconnectionBD();
            System.out.println("Proceso de Consulta finalizado correctamente");
        }catch (Exception e){
            System.out.println("No se puedo listar mensajes");
            System.out.println(e);
        }


    }
    public static void borrarMensajeDB(int ID_MENSAJE){
        PreparedStatement ps = null;
        try{
            String query = "DELETE FROM dbo.mensajes WHERE ID_MENSAJE = ?";
            ps = ConnectionDataBase.connection.prepareStatement(query);
            ps.setInt(1, ID_MENSAJE);
            ps.executeUpdate();
            System.out.println("El mensaje eliminado correctamente");
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("No se borro mensaje");

        }

    }
    public static void editarMensajeDB(ClsMensajes mensaje){
        PreparedStatement ps = null;
        try{
            String query = "UPDATE mensajes SET MENSAJE = ? WHERE ID_MENSAJE = ?";
            ps = ConnectionDataBase.connection.prepareStatement(query);
            ps.setString(1, mensaje.getMENSAJE());
            ps.setInt(2, mensaje.getID_MENSAJE());
            ps.executeUpdate();
            System.out.println("El mensaje actualizo correctamente");
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("No se actualizo mensaje");

        }

    }
}
