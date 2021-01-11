package week10d05;

import java.util.Arrays;

public class Calculator {

    public int findMinSum(int[] arr) {
        if (arr.length < 4) {
            throw new IllegalArgumentException("Kevés az adat.");
        }
        int minSum = 0;
        int minIndex = 0;
        int minValue;
        for (int j = 0; j < 4 ; j++) {
            minValue = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= minValue) {
                    minValue = arr[i];
                    minIndex = i;
                }
            }
            arr[minIndex] = Integer.MAX_VALUE;
            minSum += minValue;
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().findMinSum(new int[]{1,3,5,7,9}));
        System.out.println(new Calculator().findMinSum(new int[]{14,10,3,5,7,0,5,8,9}));
        System.out.println(new Calculator().findMinSum(new int[]{0,0,0,0,0,0,0}));
        System.out.println(new Calculator().findMinSum(new int[]{4,10,3,5,7,9}));
        System.out.println(new Calculator().findMinSum(new int[]{14,10,14,10,14,10,14}));
    }
}
