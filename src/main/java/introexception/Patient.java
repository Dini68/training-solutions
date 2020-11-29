package introexception;

public class Patient {

    String name;

    String socialSecurityNumber;

    int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (name.equals("")) {
            throw new IllegalArgumentException("A név nem lehet üres!");
        }
        if (yearOfBirth < 1900) {
            throw new IllegalArgumentException("Legalább 1900-nak kell lennie a születési évnek!");
        }
        if (!new SsnValidator().isValidSsn(socialSecurityNumber)) {
            throw new IllegalArgumentException("Ez nem TAJ szám!");
        }
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public static void main(String[] args) {
        Patient patient = new Patient("Kovács Dénes", "770254179",1968);

        System.out.println("Név: " + patient.getName() + " TAJ szám: " + patient.getSocialSecurityNumber() +
                           " Születési év: " + patient.getYearOfBirth());
    }
}
