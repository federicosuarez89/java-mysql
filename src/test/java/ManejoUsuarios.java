import datos.UsuarioJDBC;
import domain.Usuario;

import java.util.List;

public class ManejoUsuarios {
    public static void main(String[] args) {
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();

        //Ejecutamos el listado de usuarios
        List<Usuario> usuarios = usuarioJDBC.seleccionar();

        //Insertamos un nuevo usuario
        //Usuario usuario1 = new Usuario("fede.suarez","1212");
        //usuarioJDBC.insertar(usuario1);

        //Modificamos un usuario
        //Usuario usuario2 = new Usuario(5,"yury.garcia","63999969");
        //usuarioJDBC.actualizar(usuario2);

        //Eliminamos un registro
        Usuario usuario3 = new Usuario(5);
        usuarioJDBC.eliminar(usuario3);

        for (Usuario usuario:usuarios) {
            System.out.println("usuario = " + usuario);
        }

    }
}
