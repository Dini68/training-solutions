package week07d03;

import java.util.List;

public class NumberList {

    public boolean isIncreasing(List<Integer> numbers) {
        int j = numbers.get(0);
        for (Integer i: numbers) {
            if (j > i) return false;
            j = i;
        }
        return true;
    }
}
