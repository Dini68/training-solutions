package attributes.person;

public class PersonMain {

    public static void main(String[] args) {

        Person person = new Person("Kovács Dénes", "AB 123456");

        System.out.println(person.personToString());

        Address address = new Address("Magyarország", "Budapest",
                "Lobogó utca 10", "1098");

        System.out.println(address.addressToString());

        person.correctData("Simon Ferenc", "BC 987654");
        System.out.println(person.personToString());

        address.correctData("Magyarország", "Budapest",
                "Vikár Béla utca 9", "1181");
        System.out.println(address.addressToString());

        Address newAddress = new Address("USA", "LA", "Lincoln str 8", "1234");

        person.moveTo(newAddress);

        System.out.println(person.getAddress().addressToString());


    }
}
