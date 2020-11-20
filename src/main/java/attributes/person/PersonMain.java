package attributes.person;

public class PersonMain {

    public static void main(String[] args) {

        Person person = new Person("Kovács Dénes", "AB 123456");

        System.out.println(person.personToString());

        Address address = new Address("Magyarország", "Budapest",
                "Lobogó utca 10", "1098");

        System.out.println(address.addressToString());
    }
}
