package aaa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Training {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (Iterator<Integer> i = numbers.iterator(); i.hasNext(); ) {
            int value = i.next();
            System.out.print((value + ", "));
            if (value % 2 == 0) {
                i.remove();
            }
        }
        System.out.println();
        System.out.println(numbers);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers2);
        System.out.println("Tömbök");
        int [] arr = new int[5];
        arr[0] = 1;
        arr[1] = 11;
        arr[2] = 12;
        arr[3] = 13;
        arr[4] = 14;
        System.out.println(Arrays.toString(new int[] {1, 3, 5, 7, 9}));
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i: arr) {
            System.out.print(i + " ");
        }
        int [] arr2 = {};
        System.out.println();
        for (int i: arr2) {
            System.out.print(i);
        }
        int [] arr3 = {1,2,3,4};
        System.out.println(Arrays.toString(arr3));
        System.out.println();
        for (int i: arr3) {
            System.out.print(i + " ");
        }

        String[] names = {"Adam", "Eve", "Jonathan"};
        List<String> nameList = Arrays.asList(names);
        System.out.println(nameList);

        Integer [] arr4 = {1,2,3,4};
        List<Integer> arr3List = Arrays.asList(arr4);

        System.out.println(Arrays.toString(new String[] {"sd", "df"}));
        System.out.println();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println(list);
        list = List.of(0,2,4,6,8);
        System.out.println(list);
        System.out.println(Arrays.asList(60,70,80,90,0));
        System.out.println(List.of(0,0,0,0,0));
    }
}
