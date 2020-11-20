package attributes.person;

public class Person {

    private String name;

    private String identificationCard;

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String personToString() {
        return "Név: " + name + "\nSzemélyi igazolvány száma: " + identificationCard;
    }
}
