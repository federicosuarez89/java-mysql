import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestJDBC {
    public static void main(String[] args)  {
        PersonaDAO personaDAO = new PersonaDAO();

        //Insertando un nuevo objeto de tipo persona
        Persona persona1 = new Persona("Carlos","Esparza","cesparza@mail.com","8888888");
        personaDAO.insertar(persona1);

        List<Persona> personas = personaDAO.seleccionar();
        //funcion lambda para recorrer e imprimir la lista de personas
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }

}
