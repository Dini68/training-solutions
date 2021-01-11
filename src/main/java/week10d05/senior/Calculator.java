package week10d05.senior;

public class Calculator {

    public int findMinSum(int[] arr) {
        int [] arrcopy = new int[arr.length];
        System.arraycopy(arr,0,arrcopy,0,arr.length);
        int minSum = 0;
        int minIndex = 0;
        int minValue;
        for (int j = 0; j < 4 ; j++) {
            minValue = arrcopy[0];
            for (int i = 0; i < arrcopy.length; i++) {
                if (arrcopy[i] <= minValue) {
                    minValue = arrcopy[i];
                    minIndex = i;
                }
            }
            arrcopy[minIndex] = Integer.MAX_VALUE;
            minSum += minValue;
        }
        return minSum;
    }

    public int findMaxSum(int[] arr) {
        int [] arrcopy = new int[arr.length];
        arrcopy = arr;
        int maxSum = 0;
        int maxIndex = 0;
        int maxValue;
        for (int j = 0; j < 4 ; j++) {
            maxValue = arrcopy[0];
            for (int i = 0; i < arrcopy.length; i++) {
                if (arrcopy[i] >= maxValue) {
                    maxValue = arrcopy[i];
                    maxIndex = i;
                }
            }
            arrcopy[maxIndex] = Integer.MIN_VALUE;
            maxSum += maxValue;
        }
        return maxSum;
    }

    public String findMinMaxSum(int[] arr) {
        if (arr.length < 4) {
            throw new IllegalArgumentException("Kevés az adat.");
        }
        return findMinSum(arr) + " " + findMaxSum(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().findMinMaxSum(new int[]{1,3,5,7,9}));
        System.out.println(new Calculator().findMinMaxSum(new int[]{14,10,3,5,7,0,5,8,9}));
        System.out.println(new Calculator().findMinMaxSum(new int[]{0,0,0,0,0,0,0}));
        System.out.println(new Calculator().findMinMaxSum(new int[]{4,10,3,5,7,9}));
        System.out.println(new Calculator().findMinMaxSum(new int[]{14,10,14,10,14,10,14}));
    }
}
