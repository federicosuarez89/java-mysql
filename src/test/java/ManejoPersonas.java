import datos.*;
import domain.Persona;

import java.sql.*;

public class ManejoPersonas {
    public static void main(String[] args) throws SQLException {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            //Para que no se haga commit de forma automatica
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            PersonaJDBC personaJDBC = new PersonaJDBC(conexion);
            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(2);
            cambioPersona.setNombre("Karla Ivonne");
            cambioPersona.setApellido("Gomez");
            cambioPersona.setEmail("kigomez@mail.com.ar");
            cambioPersona.setTelefono("33333333");
            //Actualizamos los datos de la persona
            personaJDBC.actualizar(cambioPersona);

            //insertamos un nuevo registro
            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Carlos");
            nuevaPersona.setApellido("Ramirez Diaz");
            personaJDBC.insertar(nuevaPersona);

            //Hacemos commit de la transaccion
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }
}
