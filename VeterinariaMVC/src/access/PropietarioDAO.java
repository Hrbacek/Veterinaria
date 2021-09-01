package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Propietario;
import utils.conexion;

/**
 *
 * @author Ángel Giraldo
 */
public class PropietarioDAO {
    
   public List<Propietario> obtenerPropietarios(){
       Connection conex;
       List<Propietario> tabla = new ArrayList<>();
       try {
            conex = conexion.getConnection();
            String consulta = " SELECT * FROM propietario ";
            Statement statement = conex.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);
            while (resultado.next()) {
                Propietario propietario = new Propietario(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
                tabla.add(propietario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return tabla;
    }
   public Propietario obtenerPropietario(String propUsuario) {
        Connection conex;
        Propietario propietario = null;
        try {
            conex = conexion.getConnection();
            String obtener = " SELECT * FROM propietario where propUsuario=?";
            PreparedStatement statement = conex.prepareStatement(obtener);
            statement.setString(1, propUsuario);
            ResultSet resultado = statement.executeQuery(obtener);
            while (resultado.next()) {
                propietario = new Propietario(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return propietario;
    }
   public void actualizarPropietario(Propietario propietario) {
        Connection conex;
        
        try {
            conex = conexion.getConnection();
            String sql = "UPDATE propietario SET  propNombre =  ?, propApellido =  ?, propTelefono = ? WHERE  propUsuario =?";
            PreparedStatement statement = conex.prepareStatement(sql);
            statement.setString(1, propietario.getPropNombre());
            statement.setString(2, propietario.getPropApellido());
            statement.setString(3, propietario.getPropTelefono());
            statement.setString(4, propietario.getPropUsuario());
            int propietariosActualizados = statement.executeUpdate();
            if (propietariosActualizados > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
   
   public void eliminarPropietario(String propUsuario) {
        Connection conex;
        try {
            conex = conexion.getConnection();
            String eliminar = " DELETE FROM propietario WHERE propUsuario =?";
            PreparedStatement statement = conex.prepareStatement(eliminar);
            statement.setString(1, propUsuario);
            int propietariosEliminados = statement.executeUpdate();
            if (propietariosEliminados > 0) {
                System.out.println(" Borrado exitoso !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
   
   public void agregarPropietario(Propietario propietario) {
        Connection conex;
        try {
            conex = conexion.getConnection();
            String insercion = "INSERT INTO propietario(propUsuario,propNombre,propApellido,propTelefono) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conex.prepareStatement(insercion);
            statement.setString(1, propietario.getPropUsuario());
            statement.setString(2, propietario.getPropNombre());
            statement.setString(3, propietario.getPropApellido());
            statement.setString(4, propietario.getPropTelefono());            
            int propietariosInsertados = statement.executeUpdate();
            if (propietariosInsertados > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue creado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
   }
    

