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
public class Mascota {
    private Integer mascotaId; //PK 
    private String mascotaNombre;
    private String propUsuarioFK; //FK
    
    public Mascota(Integer mascotaId, String mascotaNombre, String propUsuario){
        this.mascotaId = mascotaId;
        this.mascotaNombre = mascotaNombre;
        this.propUsuarioFK  = propUsuario;
        
    }

    public Integer getMascotaId() {
        return mascotaId;
    }

    public String getMascotaNombre() {
        return mascotaNombre;
    }

    public String getPropUsuarioFK() {
        return propUsuarioFK;
    }

    public void setMascotaNombre(String mascotaNombre) {
        this.mascotaNombre = mascotaNombre;
    }
    
    
}
