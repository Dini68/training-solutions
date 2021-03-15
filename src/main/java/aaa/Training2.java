package aaa;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Training2 {

    public static void main(String[] args) {
        List l = new ArrayList();
        l.add(2);
        l.add("rtrt");
        l.add('c');
        l.add(LocalTime.of(6,5));
        int s = (Integer) l.get(0);
        System.out.println(s);
        System.out.println(l);
// tömb
        int [] arr = {2, 3, 5, 7};
        System.out.println(Arrays.toString(arr));
        for (int i: arr) {
            System.out.println(i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ". " + arr[i]);
        }
        arr = new int[] {5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
// lista
        List<Integer> numbers = Arrays.asList(1, 4, 6, 8, 9);
        System.out.println(numbers);
        for (int i: numbers) {
            System.out.println(i);
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(i + ". " + numbers.get(i));
        }
        numbers = List.of(0, 1, 2, 3, 4, 5);
        System.out.println(numbers);
    }
}
