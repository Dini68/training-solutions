package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserValidator userValidator = new UserValidator();

        System.out.print("User name: ");
        String userName = scanner.nextLine();

        System.out.println("User name: " + userName);

        System.out.println(userValidator.isValidUsername(userName) ?
                "A megadás helyes" : "A megadás hibás");

        System.out.print("Password: ");
        String password1 = scanner.nextLine();

        System.out.print("Password again: " );
        String password2 = scanner.nextLine();

        System.out.println("Password: " + password1);
        System.out.println("Password again: " + password2);

        System.out.println(userValidator.isValidPassword(password1, password2) ?
                "A megadás helyes" : "A megadás hibás");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("Email: " + email);

        System.out.println(userValidator.isValidEmail(email) ?
                "A megadás helyes" : "A megadás hibás");

    }
}
