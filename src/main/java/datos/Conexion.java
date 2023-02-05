package datos;

import java.sql.*;

public class Conexion {
    //Cadena de conexion a mysql
    private static final String JDBC_URL = "jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC";
    //Establecemos el usuario para conexion
    private static final String JDBC_USER = "root";
    //Establecemos la contraseña de conexion
    private static final String JDBC_PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
         return DriverManager.getConnection(JDBC_URL, JDBC_USER,JDBC_PASSWORD);
    }

    //Cerramos el flujo
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(PreparedStatement smtm){
        try {
            smtm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
