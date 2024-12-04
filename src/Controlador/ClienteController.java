/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClienteController {

    private Connection conexion;

    public ClienteController(com.sun.jdi.connect.spi.Connection conexion) {
        this.conexion = (Connection) conexion;
    }

    public ClienteController(Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Método para limpiar los campos
    public void limpiarCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }

    // Método para guardar cliente
    public void guardarCliente(String id, String nombre, String apellido, String telefono, String direccion) {
        try {
            String sql = "INSERT INTO clientes (id, nombre, apellido, telefono, direccion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, telefono);
            stmt.setString(5, direccion);

            int resultado = stmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente guardado exitosamente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
        }
    }

    // Método para modificar cliente
    public void modificarCliente(String id, String nombre, String apellido, String telefono, String direccion) {
        try {
            String sql = "UPDATE clientes SET nombre=?, apellido=?, telefono=?, direccion=? WHERE id=?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, telefono);
            stmt.setString(4, direccion);
            stmt.setString(5, id);

            int resultado = stmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente modificado exitosamente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: " + e.getMessage());
        }
    }

    // Método para eliminar cliente
    public void eliminarCliente(String id) {
        try {
            String sql = "DELETE FROM clientes WHERE id=?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, id);

            int resultado = stmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
        }
    }

    // Método para buscar cliente
    public ResultSet buscarCliente(String id) {
        try {
            String sql = "SELECT * FROM clientes WHERE id=?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, id);

            return stmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage());
            return null;
        }
    }
}
