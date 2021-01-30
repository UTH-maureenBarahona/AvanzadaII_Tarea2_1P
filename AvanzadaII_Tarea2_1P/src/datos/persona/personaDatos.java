/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.persona;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import recursos.persona;
import utilitario.conexion;

/**
 *
 * @author maureen
 */
public class personaDatos {

    conexion con = new conexion();

    public static int secuenciaCodPersona() throws SQLException {
        int cod = 0;
        try {

            Connection cn = (Connection) conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT MAX(codPersona) FROM persona";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                cod = rs.getInt(1);
                if (rs.wasNull()) {
                    cod = 0;
                }
            }
            rs.close();
            cn.close();
            cod = cod + 1;

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return cod;
    }

    public static List<persona> LeerPersona() throws SQLException {
        List<persona> personas = new ArrayList<persona>();
        try {
            Connection cn = (Connection) conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT codPersona, nomPersona, ciudadPersona FROM persona";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                persona person = new persona();
                person.setCodPersona(rs.getInt(1));
                person.setNomPersona(rs.getString(2));
                person.setCiudad(rs.getString(3));
                personas.add(person);
            }
            rs.close();
            cn.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());

        }
        return personas;
    }

    public static String InsertarPersona(persona person) throws SQLException {
        try {
            int cod = secuenciaCodPersona();
            Connection cn = (Connection) conexion.ObtenerConexion();
            String sql = "INSERT INTO persona VALUES(?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.setString(2, person.getNomPersona());
            ps.setString(3, person.getCiudad());
            ps.execute();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static String ActualizaPersona(persona person) throws SQLException {
        try {
            Connection cn = (Connection) conexion.ObtenerConexion();
            String sql = "UPDATE persona SET nomPersona= ?, ciudadPersona=? WHERE codPersona=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, person.getNomPersona());
            ps.setString(2, person.getCiudad());
            ps.setInt(3, person.getCodPersona());
            ps.execute();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    
    public static String EliminarPersona(persona person) throws SQLException {
      try {
            Connection cn = (Connection) conexion.ObtenerConexion();
            String sql = "DELETE FROM persona WHERE codPersona=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, person.getCodPersona());
            ps.execute();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    
    public static List<persona> BuscarPersona(persona person) throws SQLException, Exception{
        List<persona> personas = new ArrayList<persona>();
        try {
            Connection cn = (Connection) conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT codPersona, nomPersona, ciudadPersona FROM persona WHERE UPPER(nomPersona) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, "%" + person.getNomPersona().toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    persona personaObjeto = new persona();
                    personaObjeto.setCodPersona(1);
                    personaObjeto.setNomPersona(rs.getString(2));
                    personaObjeto.setCiudad(rs.getString(3));
                    personas.add(personaObjeto);
                } while (rs.next());

            } else {
                throw new Exception("No encontro coincidencia");

            }
            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());

        }
        return personas;
    }



}
