import org.example.IsValidEmail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class IsValidEmailTest {

    @BeforeAll
    public static void setUpClass() {
    }

    @Test
    public void testEmailValido() {
        System.out.println("Caso: Email correcto estándar");
        IsValidEmail instance = new IsValidEmail();

        assertTrue(instance.validoEmail("erick@gmail.com"));
        assertTrue(instance.validoEmail("usuario.nombre@empresa.com.pe"));
    }


    @Test
    public void testEmailNuloOVacio() {
        System.out.println("Caso: Email nulo o vacío");
        IsValidEmail instance = new IsValidEmail();


        Exception exceptionNull = assertThrows(IllegalArgumentException.class, () -> {
            instance.validoEmail(null);
        });

        // Probamos que lance la excepción con vacío
        Exception exceptionEmpty = assertThrows(IllegalArgumentException.class, () -> {
            instance.validoEmail("");
        });
    }


    @Test
    public void testFormatoBasicoInvalido() {
        System.out.println("Caso: Formato básico incorrecto");
        IsValidEmail instance = new IsValidEmail();

        assertFalse(instance.validoEmail("erickgmail.com")); // Sin arroba
        assertFalse(instance.validoEmail("erick@gmailcom")); // Sin punto
        assertFalse(instance.validoEmail("erick @gmail.com")); // Con espacio
    }


    @Test
    public void testMultiplesArrobas() {
        System.out.println("Caso: Más de una arroba");
        IsValidEmail instance = new IsValidEmail();

        assertFalse(instance.validoEmail("erick.name@gmail@com"));
    }


    @Test
    public void testUsuarioInvalido() {
        System.out.println("Caso: Usuario mal formado");
        IsValidEmail instance = new IsValidEmail();

        assertFalse(instance.validoEmail("@gmail.com"));      // Usuario vacío
        assertFalse(instance.validoEmail(".erick@gmail.com")); // Empieza con punto
        assertFalse(instance.validoEmail("erick.@gmail.com")); // Termina con punto
        assertFalse(instance.validoEmail("er..ick@gmail.com")); // Dos puntos seguidos
    }


    @Test
    public void testDominioInvalido() {
        System.out.println("Caso: Dominio mal formado");
        IsValidEmail instance = new IsValidEmail();


        assertFalse(instance.validoEmail("erick@a.com"));


        assertFalse(instance.validoEmail("erick@gmail.com."));
    }

    //test constructor por si las dudas
    @Test
    public void testInstanciacion() {
        assertNotNull(new IsValidEmail());
    }


}

