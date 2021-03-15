package aaa;

import java.util.*;

public class SortIntro {

    public static void main(String[] args) {
        int[] numbers = new int[10_000_000];
        Random rnd = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt(10_000_000);
        }
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(numbers.length);
        Arrays.sort(numbers);
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(numbers.length);

        int findNumber = 2_345_678;
        int step = 0;
        boolean isFound = false;
        for(int i: numbers) {
            step ++;
            if (i == findNumber) {
                isFound = true;
                break;
            }
        }
        System.out.println(step);
        System.out.println(numbers[step -  1]);

        step = 0;
        isFound = false;
        int min = 0;
        int max = numbers.length;
        while (min < max) {
            step ++;
            if (numbers[(max + min) / 2] < findNumber) {
                min = (max + min + 1) / 2;
            }
            if (numbers[(max + min) / 2] > findNumber) {
                max = (max + min) / 2;
            }
            if (numbers[(max + min) / 2] == findNumber) {
                min = max;
                System.out.println(findNumber);
            }
        }

        System.out.println(step);
    }
}
