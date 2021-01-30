/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author maureen
 */
public class persona {
    private int codPersona;
    private String nomPersona;
    private String ciudad;
    
    public persona(){
    super();
    }

    public persona(int codPersona, String nomPersona, String ciudad) {
        this.codPersona = codPersona;
        this.nomPersona = nomPersona;
        this.ciudad = ciudad;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public String getNomPersona() {
        return nomPersona;
    }

    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
}
