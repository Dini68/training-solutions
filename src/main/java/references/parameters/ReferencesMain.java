package references.parameters;

import references.parameters.Person;

import java.util.Arrays;

public class ReferencesMain {

    public static void main(String[] args) {

        Person person1;
        Person person2;

        Person newPerson = new Person("K",25);
        person1 = newPerson;
        person2 = person1;
        person2.setName("D");
        System.out.println("person1: " + person1 + " " + person1.toString());
        System.out.println("person2: " + person2 + " " + person2.toString());
        System.out.println("A két változó referenciája ugyanarra az objektumra mutat.\n");
        // a refernciák ugyanarra az objektumra mutatnak

        int a = 24;
        int b = a;
        b +=1;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("A prímitív típus esetén nincs hatás a másikra.\n");

        Person new2Person = new Person("H",9);
        person1 = new2Person;

        System.out.println("person1: " + person1 + " " + person1.toString());
        System.out.println("person2: " + person2 + " " + person2.toString());
        System.out.println("A két változó referenciája különböző objektumokra mutat.\n");
        // a refernciák ugyanarra az objektumra mutatnak

    }
}
