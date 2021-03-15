package aaa;

import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collector;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    void testSort() {
        List<String> names = Arrays.asList("Joe", "Jack", "Jane", "Ábel", "éva", "joe");
        Collections.sort(names);
        System.out.println(names);
        Collections.sort(names, Collator.getInstance(new Locale("hu","HU")));
        System.out.println(names);
    }


    @Test
    void testTrainersSort() {
        List<Trainer> trainers = Arrays.asList(
                new Trainer("Joe", 3),
                new Trainer("Jack", 2),
                new Trainer("Jane", 1)
        );
        Collections.sort(trainers);
        System.out.println(trainers);

        Collections.sort(trainers, new Comparator<Trainer>() {

            @Override
            public int compare(Trainer o1, Trainer o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        System.out.println(trainers);

        Collections.sort(trainers, new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });

        System.out.println(trainers);


    }
    public class SalaryComparator implements Comparator<Trainer> {
        @Override
        public int compare(Trainer o1, Trainer o2) {
            return o1.getSalary()-o2.getSalary();
        }
    }


}