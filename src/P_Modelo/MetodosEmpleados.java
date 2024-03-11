package P_Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetodosEmpleados {

    Conexion_Sqlite con = new Conexion_Sqlite();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public int Agregar(Empleados u) {
        int r = 1;
        String sql = "INSERT INTO reg_empleados (id_emple, nom_emple, ape_emple, ced_emple, tele_emple, usuario, clave, rol) VALUES (?,?,?,?,?,?,?,?)";
        try {
            //cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, Integer.toString(u.getId()));
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getCed());
            ps.setString(5, u.getTelefono());
            ps.setString(6, u.getUsuario());
            ps.setString(7, u.getClave());
            ps.setString(8, Integer.toString(u.getRol()));
            ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo establecer conexión");
        }
        return r;
    }

    public List listar() {

        String sql = "SELECT * FROM reg_empleados";
        List<Empleados> lista = new ArrayList<>();

        try {
            //cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleados u = new Empleados();
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setTelefono(rs.getString(4));
                u.setCed(rs.getString(5));
                u.setUsuario(rs.getString(6));
                u.setClave(rs.getString(7));
                u.setRol(rs.getInt(8));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("No se pudo establecer conexión");
        }
        return lista;
    }
}
