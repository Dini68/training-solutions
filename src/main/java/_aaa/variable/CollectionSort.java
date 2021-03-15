package _aaa.variable;

import java.text.Collator;
import java.util.*;

public class CollectionSort {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>(Arrays.asList(4, 7, 6, 1));
        System.out.println(intList);

        Collections.sort(intList);
        System.out.println(intList);

        intList.sort(Collections.reverseOrder());
//        Collections.sort(intList, Collections.reverseOrder());
        System.out.println(intList);

        List<String> names = new ArrayList<>();
        names.add("Hunor");
        names.add("Dénes");
        names.add("Gergő");
        names.add("Dominik");
        names.add("Erik");
        names.add("Levente");
        names.add("Soma");
        names.add("Dusi");
        names.add("Bence");
        names.add("Ákos");
        names.add("Éva");

        System.out.println(names);

        List<String> copyNames = new ArrayList<>(names);

        Collections.sort(copyNames, Collator.getInstance(new Locale("hu", "HU")));
        System.out.println(copyNames);
        Collections.sort(copyNames,Collections.reverseOrder());
        System.out.println(copyNames );
        copyNames.sort(Collections.reverseOrder());
        System.out.println(copyNames);
        System.out.println(names);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Hunor", 1000));
        students.add(new Student("Gergő", 2000));
        students.add(new Student("Dominik", 10000));
        students.add(new Student("Erik", 5000));
        students.add(new Student("Soma", 100));

        List<Student> copyStudents = new ArrayList<>(students);
        Collections.sort(copyStudents, Collator.getInstance(new Locale("hu", "HU")));

        copyStudents.sort(new NameComparator());
        System.out.println(copyStudents);

        copyStudents.sort(new BalanceComparator());
        System.out.println(copyStudents);

        System.out.println(students);

        }

}
