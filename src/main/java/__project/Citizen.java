package __project;

public class Citizen {

    private String fullName;
    private String zip;
    private int age;
    private String email;
    private String socialSecurityNumber;
    private String city;

    public Citizen(String fullName, String zip, int age, String email, String socialSecurityNumber) {
        this.fullName = fullName;
        this.zip = zip;
        this.age = age;
        this.email = email;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Citizen(String fullName, String zip, int age, String email, String socialSecurityNumber, String city) {
        this.fullName = fullName;
        this.zip = zip;
        this.age = age;
        this.email = email;
        this.socialSecurityNumber = socialSecurityNumber;
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }

    public String getZip() {
        return zip;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "fullName='" + fullName + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                '}';
    }
}
