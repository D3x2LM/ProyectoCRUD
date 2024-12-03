package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasClientes extends Conexion{

    public boolean Guardar(Clientes clt) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO clientes(descripción, dirección, teléfono, ruc) VALUES (?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clt.getDescripción());
            ps.setString(2, clt.getDirección());
            ps.setString(3, clt.getTeléfono());
            ps.setString(4, clt.getRuc());
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

    public boolean Nuevo(Clientes clt) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE productos set descripción=?, dirección=?, teléfono=?, ruc=? where id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clt.getDescripción());
            ps.setString(2, clt.getDirección());
            ps.setString(3, clt.getTeléfono());
            ps.setString(4, clt.getRuc());
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

    public boolean Eliminar(Clientes clt) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM clientes where id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, clt.getId());
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
        String sql = "SELECT * FROM productos where ruc = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clt.getRuc());
            rs = ps.executeQuery();

            if (rs.next()) {
                clt.setId(Integer.parseInt(rs.getString("id")));
                clt.setDirección(rs.getString("dirección"));
                clt.setDescripción(rs.getString("descripción"));
                clt.setTeléfono(rs.getString("teléfono"));
                clt.setRuc(rs.getString("ruc"));
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
