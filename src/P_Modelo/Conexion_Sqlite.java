package P_Modelo;

import java.sql.*;

public class Conexion_Sqlite {
    String url = "jdbc:sqlite:C:\\Users\\andre\\Desktop\\proyect-sunset\\APP sunset\\APP sunset\\APP sunset\\APP sunset\\sunset.db";
    Connection con;

    public Conexion_Sqlite(){
        try {  
            con = DriverManager.getConnection(url);
            System.out.println(con);
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos" + e);
        }

    }
    
}
