
package Controlador;

import Modelo.ConsultasProductos;
import Modelo.Productos;
import Vista.frmProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlProducto implements ActionListener {
    
    private final Productos modelo;
    private final ConsultasProductos consultas;
    private final frmProductos vista;
    public ControlProductos(Productos modelo, ConsultasProductos consultas, frmlProductos vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }
    
    
}
