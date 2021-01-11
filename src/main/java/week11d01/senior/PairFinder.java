package week11d01.senior;

import java.util.ArrayList;
import java.util.Arrays;

public class PairFinder {

    public int findPairs(int[] arr) {
        int numberOfPairs = 0;
        Arrays.sort(arr);
        int same = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                same ++;
            }
            if (arr[i] != arr[i-1] || i == arr.length - 1) {
                numberOfPairs += same / 2;
                same = 1;
            }
        }
        return numberOfPairs;
    }
}
