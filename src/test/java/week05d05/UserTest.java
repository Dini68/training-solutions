package week05d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import schoolrecords.Student;
import week05d04.Product;

import java.util.MissingFormatArgumentException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void getFullNameTest() {
        User user = new User("Dénes","Kovács","kdini68@gmail.com");
        assertEquals("Dénes Kovács", user.getFullName());
    }

    @Test
    public void charactersInEmailTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new User("Dénes", "Kovács", "kdini68gmail.com"));
        assertEquals("Hiányzik a '@' karakter", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () ->
                new User("Dénes","Kovács","@kdini68gmailcom"));
        assertEquals("Nem kezdődhet '@' karakterrel", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () ->
                new User("Dénes","Kovács","kdini68@gmailcom"));
        assertEquals("Hiányzik a '.' karakter", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () ->
                new User("Dénes","Kovács","kdini.68@gmailcom"));
        assertEquals("A '.' karakternek a '@' után kell lennie.", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () ->
                new User("Dénes","Kovács","kdini68@gmailcom."));
        assertEquals("A '.' karakter nem lehet utolsó.", ex.getMessage());
    }
    @Test
    public void testNameValid() {
        assertThrows(IllegalArgumentException.class, () -> new User("  ","Kovács","kdini68@gmail.com"));
        assertThrows(IllegalArgumentException.class, () -> new User(null,"Kovács","kdini68@gmail.com"));
        assertThrows(IllegalArgumentException.class, () -> new User("Dénes","  ","kdini68@gmail.com"));
        assertThrows(IllegalArgumentException.class, () -> new User("Dénes",null,"kdini68@gmail.com"));
    }
}
