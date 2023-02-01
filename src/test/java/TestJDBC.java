import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestJDBC {
    public static void main(String[] args)  {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas = personaDAO.seleccionar();
        //funcion lambda para recorrer e imprimir la lista de personas
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
