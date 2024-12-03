
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasProveedores extends Conexion{
    
     public boolean Guardar(Proveedores prv) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO clientes(descripción, dirección, teléfono, ruc) VALUES (?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, prv.getDescripción());
            ps.setString(2, prv.getDirección());
            ps.setString(3, prv.getTeléfono());
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

    public boolean Nuevo(Proveedores prv) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE productos set descripción=?, dirección=?, teléfono=? where id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, prv.getDescripción());
            ps.setString(2, prv.getDirección());
            ps.setString(3, prv.getTeléfono());
            ps.execute();
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

    public boolean Eliminar(Proveedores prv) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM clientes where id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, prv.getId());
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

    public boolean Informe(Clientes clt) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "SELECT * FROM productos where id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clt.getRuc());
            rs = ps.executeQuery();

            if (rs.next()) {
                clt.setId(Integer.parseInt(rs.getString("id")));
                clt.setDirección(rs.getString("dirección"));
                clt.setDescripción(rs.getString("descripción"));
                clt.setTeléfono(rs.getString("teléfono"));
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
