package patient;

public class Patient {

    private String name;

    private String socialSecurityNumber;

    private int yearOfBirth;

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Patient(String name, String ssn, int yearOfBirth) {
        this.name = name;
        this.socialSecurityNumber = ssn;
        this.yearOfBirth = yearOfBirth;
    }

}
