package week09d03;

import java.util.Random;

public class Person {

    private String name;

    private int age;

    private Present present;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }

    @Override
    public String toString() {
        return name + " " + age + " present: " + present;
    }

    public void setPresent() {
        int presentItems = Present.values().length;
        if (age > 14) {
            this.present = Present.values()[new Random().nextInt(presentItems-1) + 1];
        }
        else {
            this.present = Present.values()[new Random().nextInt(presentItems)];
        }

    }

    public static void main(String[] args) {
        Person person = new Person("KD",52);
        person.setPresent();
        System.out.println(person.present);
        Person person2 = new Person("KD",12);
        person2.setPresent();
        System.out.println(person2.present);
    }
}
