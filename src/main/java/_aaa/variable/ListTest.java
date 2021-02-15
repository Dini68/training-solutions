package _aaa.variable;

import _toto.ppp.A;

import java.text.Collator;
import java.util.*;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(15);
        numbers.add(-15);
        numbers.add(35);
        numbers.add(17);
        System.out.println(numbers);

        List<Integer> numbers2 = Arrays.asList(213, -8, 7, 87);
        System.out.println(numbers2);

        Collections.sort(numbers);
        Collections.sort(numbers2, Collections.reverseOrder());

        System.out.println(numbers);
        System.out.println(numbers2);

        Collections.reverse(numbers);
        System.out.println(numbers);

        List<Integer> numbers3 = Arrays.asList(213, -8, 7, 87);
        numbers3.sort(Comparator.naturalOrder());
        System.out.println(numbers3);

        List<String> names = new ArrayList<>(Arrays.asList("John", "Jane", "Jack", "Smith"));
        System.out.println(names);
        names.sort(Comparator.naturalOrder());
        System.out.println(names);
        names.add("Eva");
        names.add("John");
        System.out.println(names);
        Collections.sort(names);
        System.out.println(names);

        System.out.println(names.lastIndexOf("John"));

        Set<String> strArr = new HashSet<>();
        strArr.add("Abel");
        strArr.add("Noe");

        names.add("Gru");
        names.sort(Comparator.naturalOrder());
        names.lastIndexOf("Gru");
        names.addAll(Arrays.asList("Kanoi", "Labo"));
        Collections.sort(names);
        System.out.println(names.remove(6));
        System.out.println(names);
        names.clear();




    }
}
