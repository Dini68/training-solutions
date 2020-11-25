package week05d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCounter {


    public int listCounter(List<String> list) {

        int counter = 0;
        if (list.size() != 0) {
            for (String s : list
            ) {
                if (s.charAt(0) == 'a' || s.charAt(0) == 'A') {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        ListCounter listCounter = new ListCounter();
        List<String> testList = new ArrayList<>();
        testList.add("Asztal");
        testList.add("malom");
        testList.add("atom");
        testList.add("akkor");

        testList.add("barack");
        testList.add("Abrak");
        testList.add("másik");
        testList.add("a");

        System.out.println(listCounter.listCounter(testList));
    }
}