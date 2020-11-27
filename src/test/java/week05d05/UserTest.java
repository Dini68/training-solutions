package week05d05;

import org.junit.jupiter.api.Test;
import week05d04.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void getFullNameTest() {
        User user = new User("Dénes","Kovács","kdini68@gmail.com");
        assertEquals("Dénes Kovács", user.getFullName());
    }

}
