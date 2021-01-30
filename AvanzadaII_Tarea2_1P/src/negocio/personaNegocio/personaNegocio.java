/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.personaNegocio;

import datos.persona.personaDatos;
import java.util.ArrayList;
import java.util.List;
import recursos.persona;

/**
 *
 * @author maureen
 */
public class personaNegocio {

    public List<persona> Leer() {
        List<persona> listaPersona = new ArrayList<>();
        try {
            listaPersona = personaDatos.LeerPersona();
        } catch (Exception e) {
            System.err.println("error Leer" + e.getMessage());
        }
        return listaPersona;
    }

    public String Insertar(persona person) {
        String respuesta = "Error";
        try {

            if (person.getCodPersona() <= 0) {
                throw new Exception("Error Insertar persona: El Codigo no debe de ser menor o igual a 0");

            }
            if (person.getNomPersona().isEmpty()) {
                throw new Exception("Error Insertar persona: El nombre no debe de estar vacio");

            }
            respuesta = personaDatos.InsertarPersona(person);
            if (respuesta == null) {
                respuesta = "Persona almacenada exitosamente";
            }
        } catch (Exception e) {
            respuesta = e.getMessage();
        } finally {
            return respuesta;
        }
    }

    public String Actualizar(persona person) {
        String respuesta = "Error";
        try {
            if (person.getNomPersona().isEmpty()) {
                throw new Exception("Error Actualizar: El nombre no debe de estar vacio");
            }
            respuesta = personaDatos.ActualizaPersona(person);
        } catch (Exception e) {
            respuesta = e.getMessage();
        } finally {
            return respuesta;
        }
    }

    public String Eliminar(persona person) {
        String respuesta = "Error";
        try {
            respuesta = personaDatos.EliminarPersona(person);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            return respuesta;
        }
    }

    public List<persona> Buscar(persona person) throws Exception {

        List<persona> listaPersona = new ArrayList<>();
        try {
            listaPersona = personaDatos.BuscarPersona(person);
        } catch (Exception e) {
            throw new Exception("error Buscar" + e.getMessage());
        }
        return listaPersona;
    }

}
