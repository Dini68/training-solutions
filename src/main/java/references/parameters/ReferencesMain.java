package references.parameters;

import java.util.ArrayList;
import java.util.Arrays;

public class ReferencesMain {

    public static void main(String[] args) {

        Person person1;
        Person person2;

        Person newPerson = new Person("K",25);
        person1 = newPerson;
        person2 = person1;
        person2.setName("D");
        System.out.println(Arrays.asList(person1.getName()));
        System.out.println(Arrays.asList(person2.getName()));
        // a refernciák ugyanarra az objektumra mutatnak

        int a = 24;
        int b = a;
        b +=1;

        System.out.println(a + " " + b);

        Person new2Person = new Person("K",52);
        person1 = new2Person;

        System.out.println(person1);
        System.out.println(new2Person);
        System.out.println(Arrays.asList(person1));
        System.out.println(Arrays.asList(new2Person));
        // ua a referencia;

    }
}
