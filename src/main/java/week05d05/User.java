package week05d05;

import java.util.MissingFormatArgumentException;

public class User {

    private String firstName;
    private String lastName;
    private String email;


    public void charactersInEmail (String email) {
        if (!email.contains("@")) {
            throw new MissingFormatArgumentException("Hiányzik a '@' karakter");
        }
        if (email.indexOf('@') == 0) {
            throw new MissingFormatArgumentException("Nem kezdődhet '@' karakterrel");
        }
        if (!email.contains(".")) {
            throw new MissingFormatArgumentException("Hiányzik a '.' karakter");
        }
        if (email.indexOf('.') < email.indexOf('@')+1) {
            throw new MissingFormatArgumentException("A '.' karakternek a '@' után kell lennie.");
        }
        if (email.indexOf('.') == email.length() - 1) {
            throw new MissingFormatArgumentException("A '.' karakter nem lehet utolsó.");
        }
    }

    public User(String firstName, String lastName, String email) {
        charactersInEmail(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public static void main(String[] args) {
        User user = new User("Dénes", "Kovács", "kdini68@gmail.com");
        System.out.println(user.getFullName());
    }
}
