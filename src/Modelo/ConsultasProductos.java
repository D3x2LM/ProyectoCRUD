package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasProductos extends Conexion {

    public boolean Guardar(Productos pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO productos(codigo, nombre, marca, modelo, precio, cantidad) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getMarca());
            ps.setString(4, pro.getModelo());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getCantidad());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public boolean Modificar(Productos pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE productos set codigo=?, nombre=?, marca=?, modelo=?, precio=?, cantidad=? where id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getMarca());
            ps.setString(4, pro.getModelo());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getCantidad());
            ps.setInt(7, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public boolean Eliminar(Productos pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM productos where id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean Buscar(Productos pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "SELECT * FROM productos where codigo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setMarca(rs.getString("marca"));
                pro.setModelo(rs.getString("modelo"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                return true;
                
            }
            
            
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }

}
