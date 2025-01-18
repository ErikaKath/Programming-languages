package com.co.mensajesapp.logica.database;

import com.co.mensajesapp.logica.utils.ClsConstantesGlobales;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/***
 * Esta clase contiene los metodos y pasos logicos para la conexion a la base de datos
 * Bogotá-Colombia
 * Erika Olivea
 * @version 1.0 2/01/2025
 */
public class ConnectionDataBase {
    private static Connection connection = null;
    private static DatabaseMetaData metaData = null;
    private static ResultSet resultSet = null;
    private static Statement stmt = null;
    private static String tipoDato;

    public static void connectionDataBase(String database) {
        System.out.println("Connection Data Base");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERROR Connection Data Base");

        }
        ClsConstantesGlobales.baseDatosSeleccion = "jdbc:sqlserver://localhost:1433;databaseName=" + database + ";user=sa;password=0903;encrypt=true;trustServerCertificate=true;";
        //System.out.println("Connection OKY");

        try {
            connection = DriverManager.getConnection(ClsConstantesGlobales.baseDatosSeleccion);
            metaData = connection.getMetaData();
            if (connection != null){
                System.out.println("Conexion exitosa");
            }
        } catch (SQLException var1) {
            var1.printStackTrace();
            System.out.println("Error de connection");
        }
    }

    public static ArrayList<Map<String, String>> consumirDatos(String sqlQuery) {
        if (sqlQuery == null || sqlQuery.trim().isEmpty()) {
            throw new IllegalArgumentException("El parámetro sqlQuery no puede ser null o vacío.");
        }

        Map<String, String> datos = new HashMap<>();
        ArrayList<Map<String, String>> obtenerDatos = new ArrayList<>();

        try {
            if (connection == null || connection.isClosed()) {
                throw new IllegalStateException("La conexión a la base de datos no está establecida o está cerrada.");
            }

            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sqlQuery);

            while (resultSet.next()) {
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    String columnName = resultSet.getMetaData().getColumnName(i);
                    String columnType = resultSet.getMetaData().getColumnTypeName(i);
                    switch (columnType.toLowerCase()) {
                        case "numeric":
                            datos.put(columnName, String.valueOf(resultSet.getDouble(columnName)));
                            break;
                        case "varchar":
                        case "nvarchar":
                        case "char":
                            datos.put(columnName, resultSet.getString(columnName));
                            break;
                        case "bigint":
                            datos.put(columnName, String.valueOf(resultSet.getLong(columnName)));
                            break;
                        case "decimal":
                            datos.put(columnName, String.valueOf(resultSet.getBigDecimal(columnName)));
                            break;
                        case "int":
                        case "tinyint":
                        case "smallint":
                            datos.put(columnName, String.valueOf(resultSet.getInt(columnName)));
                            break;
                        case "datetime":
                            datos.put(columnName, String.valueOf(resultSet.getDate(columnName)));
                            break;
                        case "float":
                            datos.put(columnName, String.valueOf(resultSet.getFloat(columnName)));
                            break;
                        default:
                            datos.put(columnName, "Tipo de dato no soportado: " + columnType);
                            break;
                    }
                }
                obtenerDatos.add(new HashMap<>(datos)); // Copia los datos actuales
                datos.clear();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error al procesar los datos de la consulta.");
        }

        ClsConstantesGlobales.sizeConsultQuery2 = obtenerDatos.size();
        return obtenerDatos;
    }
}

