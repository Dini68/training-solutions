package stringtype.registration;

public class UserValidator {

    public Boolean isValidUsername (String username) {
        boolean jomegadas = true;
        if (username.length() < 1) {
            System.out.println("Nincs megadva felhasználó név!");
            jomegadas = false;
        }
        return jomegadas;
    }

    public Boolean isValidPassword(String password1, String password2){
        Boolean jomegadas = true;
        if (password1.length()<8) {
            System.out.println("Kevés a karakter!");
            jomegadas = false;
        }
        if (!password1.equals(password2)) {
            System.out.println("Nem egyezik meg a két jelszó!");
            jomegadas = false;
        }
        return jomegadas;
    }

    public Boolean isValidEmail(String email) {

        Boolean jomegadas = true;

        if (!email.contains("@")) {
            System.out.println("Az email címben hiányzik a \"@\" karakter!");
            jomegadas = false;
        }

        if (!email.contains(".")) {
            System.out.println("Az email címben hiányzik a \".\" karakter!");
            jomegadas = false;
        }

        if (email.contains("@") && (email.indexOf("@") == 0)) {
            System.out.println("A \"@\" nem lehet az első karakter!");
            jomegadas = false;
        }

        if (email.contains(".") && email.contains("@") &&
                ((email.indexOf(".") - email.indexOf("@")) == 1)) {
            System.out.println("A \"@\" és  a\".\" nem lehetnek egymás után!");
            jomegadas = false;
        }

        if (email.contains(".") && email.contains("@") &&
                ((email.indexOf(".") - email.indexOf("@")) < 0)) {
            System.out.println("A \".\" nem lehet a  a\"@\" előtt!");
            jomegadas = false;
        }

        if (email.contains(".") && email.indexOf(".") == email.length() - 1)  {
            System.out.println("A \".\" nem lehet az utolsó karakter!");
            jomegadas = false;
        }

        return jomegadas;
    }

}
