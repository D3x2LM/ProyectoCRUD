
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasEmpleados extends Conexion{
    
    public boolean Guardar(Empleados emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO empleados(codigo, nombre, apellido, distrito, ,edad, dni, género, turno, modalidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getCodigo());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setString(4, emp.getDistrito());
            ps.setInt(5, emp.getEdad());
            ps.setString(6, emp.getDni());
            ps.setString(7, emp.getGénero());
            ps.setString(8, emp.getTurno());
            ps.setString(9, emp.getModalidad());
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

    public boolean Modificar(Empleados emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE productos set codigo=?, nombre=?, apellido=?, distrito=?, edad=?, dni=?, género=?, turno=?, modalidad=?  where id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getCodigo());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setString(4, emp.getDistrito());
            ps.setInt(5, emp.getEdad());
            ps.setString(6, emp.getDni());
            ps.setString(7, emp.getGénero());
            ps.setString(8, emp.getTurno());
            ps.setString(9, emp.getModalidad());
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

    public boolean Eliminar(Empleados emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM productos where id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, emp.getId());
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
    
    public boolean Buscar(Empleados emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "SELECT * FROM productos where codigo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getCodigo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                emp.setId(Integer.parseInt(rs.getString("id")));
                emp.setCodigo(rs.getString("codigo"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setDistrito(rs.getString("distrito"));
                emp.setEdad(Integer.parseInt(rs.getString("edad")));
                emp.setDni(rs.getString("dni"));
                emp.setGénero(rs.getString("género"));
                emp.setTurno(rs.getString("turno"));
                emp.setModalidad(rs.getString("modalidad"));
                
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
