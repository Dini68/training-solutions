package week05d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCounter {


    public int listCounter(List<String> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("Not list.");
        }

        int count = 0;
            for (String s : list
            ) {
                if (s.charAt(0) == 'a' || s.charAt(0) == 'A') {
                    count++;
                }
            }
        return count;
    }

}