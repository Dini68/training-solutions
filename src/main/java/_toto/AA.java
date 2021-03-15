package _toto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AA {

    public static void main(String[] args) {
        Integer[] num = {5, 4, 2, 3};

        System.out.println(Arrays.toString(num));

        Arrays.sort(num);

        System.out.println(Arrays.toString(num));

        System.out.println(Arrays.asList(num));

        String[] names = {"Jonathan", "Adam",  "Eve"};
        System.out.println(Arrays.toString(names));
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));

        String[] names2 = {"Jonathan", "Adam",  "Eve"};
        System.out.println(Arrays.toString(names2));
        List<String> nameList2 = Arrays.asList(names2);
        Collections.sort(nameList2);
        System.out.println(nameList2);

        List<Integer> l = Arrays.asList(num);
        System.out.println(l);
    }
}
