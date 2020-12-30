package week09d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SantaClausTest {

    @Test
    public void setPresentTest() {

        Person person = new Person("Simon Tünde",50);
        Person person1 = new Person("Kovács Hunor",9);
        Person person2 = new Person("K Dénes",52);

        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person1);
        persons.add(person2);

        SantaClaus santaClaus = new SantaClaus(persons);
        for (Person p: persons) {
            p.setPresent();
            System.out.println(p.toString());
        }

        assertEquals(52, persons.get(2).getAge());
        assertEquals("Kovács Hunor", persons.get(1).getName());
        assertFalse(Present.TOY == persons.get(0).getPresent());
    }
}

