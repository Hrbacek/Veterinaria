/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ángel Giraldo
 */
public class Propietario {
    private String propUsuario; //PK 
    private String propApellido;
    private String propNombre;
    private String propTelefono;
    public Propietario(String propUsuario, String propNombre, String propApellido, String propTelefono){
        this.propUsuario  = propUsuario;
        this.propNombre   = propNombre;
        this.propApellido = propApellido;
        this.propTelefono = propTelefono;
    }

    public String getPropUsuario() {
        return propUsuario;
    }

    public String getPropApellido() {
        return propApellido;
    }

    public String getPropNombre() {
        return propNombre;
    }

    public String getPropTelefono() {
        return propTelefono;
    }

    public void setPropApellido(String propApellido) {
        this.propApellido = propApellido;
    }

    public void setPropNombre(String propNombre) {
        this.propNombre = propNombre;
    }

    public void setPropTelefono(String propTelefono) {
        this.propTelefono = propTelefono;
    }
    
}
