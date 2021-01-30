/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;


import java.sql.SQLException;

/**
 *
 * @author maureen
 */
public class main {

    public static void main(String[] args) throws SQLException {
    conexion con = new conexion();
    con.ObtenerConexion();
    }
    
}
