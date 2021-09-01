/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Ángel Giraldo
 */

    public class VistaVeterinaria extends JFrame {
    public VistaVeterinaria() {
        initComponents();
    }

    private void initComponents() {        
        // Establece el titulo de la ventana
        setTitle("Sistema de Gestión de Libros");
        
        // Crea un panel para alojar la tabla*/
        PanelClientes panelClientes = new PanelClientes();
        // Sirve de panel principal de la ventana
        setContentPane(panelClientes);
        // Adjusta el tamaño de la ventana para que quepan todos los componentes
        pack();
        //setSize(800, 600);
        // Permite ubicar la ventana en el centro de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        // Hace que la ventana de la aplicación sea visible
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    
    

    
    public static void main(String[] args){
        VistaVeterinaria vistaVeterinaria = new VistaVeterinaria();
        System.out.print("ja");
    }
 }
