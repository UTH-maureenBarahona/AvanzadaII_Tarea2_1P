/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import java.sql.*;

/**
 *
 * @author maureen
 */
public class conexion {

    public static Connection ObtenerConexion() {
 Connection connection = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
           
            // Database connect
            // Conectamos con la base de datos
            connection = DriverManager.getConnection(
                    "jdbc:mysql://34.70.245.154:3306/avanzada?useSSL=false",
                    "root", "5MMvznviaall8mkr");
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
        return connection;
    }

}
