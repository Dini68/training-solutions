package week13d01;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EqualsTest {

    @Test
    public void testEquals() {
        String s = new String("John");
        String s2 = new String("John");

        Trainer trainer = new Trainer("John Doe", 1980);
        Trainer trainer2 = new Trainer("John Doe", 2000);
        Trainer trainer3 = new Trainer("John Doe", 1980);

        List<Integer> l = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(1, 2, 4);


        assertEquals(false, trainer.equals(trainer2));
        assertEquals(true, trainer.equals(trainer3));

    }

    @Test
    public void testHashCode() {
        Trainer trainer = new Trainer("John Doe", 1990);
        System.out.println(trainer);
        Trainer trainer1 = new Trainer("John Doe", 1990);
        System.out.println(trainer1);
        assertEquals(true,trainer.equals(trainer1));
        assertEquals(true,trainer.hashCode() == trainer1.hashCode());
    }


    @Test
    void testSet () {

//        List<String> introList = Arrays.asList("kkk", "oio", "kkk");
//        Set<String> introSet = new Set<String>() {
        }


}
