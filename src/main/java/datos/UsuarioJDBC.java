package datos;


import domain.*;
import java.sql.*;
import java.util.*;

public class UsuarioJDBC {
    private static final String SQL_SELECT = "SELECT id_usuario, username, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(username, password) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET username=?, password=? WHERE id_usuario=?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";
    public List<Usuario> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario>usuarios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            //iteramos la lista para ver si hay mas que recorrer
            while (rs.next()){
                int id_usuario = rs.getInt("id_usuario");
                String username = rs.getString("username");
                String password = rs.getString("password");
                //Creamos objetos de tipo persona
                usuario = new Usuario(id_usuario,username,password);
                //Agregamos cada persona a la lista
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
        }
        return usuarios;

    }

    public int insertar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: "+SQL_INSERT);
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            //Vemos la cantidad de registros que fueron afectados
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: "+rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

                Conexion.close(stmt);
                Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: "+SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getId_usuario());
            //Vemos la cantidad de registros que fueron afectados
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: "+rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                Conexion.close(stmt);
                Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: "+SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,usuario.getId_usuario());
            //Vemos la cantidad de registros que fueron afectados
            rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                Conexion.close(stmt);
                Conexion.close(conn);
        }
        return rows;
    }

}
