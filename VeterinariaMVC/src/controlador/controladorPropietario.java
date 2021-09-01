/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import access.PropietarioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Propietario;

/**
 *
 * @author Ángel Giraldo
 */
public class controladorPropietario {
    private PropietarioDAO propietarioDAO;

    public controladorPropietario(PropietarioDAO propietarioDAO) {
        this.propietarioDAO = propietarioDAO;
    }

    public DefaultTableModel consultarPropietarios() {
        String[] titulos = {"Usuario", "Nombres", "Apellidos", "Telefono"};
        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        List<Propietario> propietarios = propietarioDAO.obtenerPropietarios();
        for (Propietario propietario : propietarios) {
            String[] registro = new String[4];
            registro[0] = propietario.getPropUsuario();
            registro[1] = propietario.getPropNombre();
            registro[2] = propietario.getPropApellido();
            registro[3] = propietario.getPropTelefono();
            tabla.addRow(registro);
        }
        return tabla;
    }

    public void actualizarPropietario(Propietario propietario) {
        propietarioDAO.actualizarPropietario(propietario);
    }

    public void agregarPropietario(Propietario propietario) {
        propietarioDAO.agregarPropietario(propietario);
    }
    
    public void eliminarPropietario(String propUsuario){
        propietarioDAO.eliminarPropietario(propUsuario);
    }
    
}
