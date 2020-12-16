package week08d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringLists {

    public List<String> stringListsUnion(List<String> first, List<String> second) {
        List<String> unionList = new ArrayList<>();
        for (String str: first) {
            unionList.add(str);
        }
        boolean isHas;
        for (String str1: second) {
            isHas = false;
            for (String str2: first) {
                if (str1.equals(str2)) {
                    isHas = true;
                }
            }
            if (!isHas) {
                unionList.add(str1);
            }
        }
        return unionList;
    }

    public static void main(String[] args) {
        StringLists sL = new StringLists();
        List<String> first = Arrays.asList("a", "b", "c");
        List<String> second = Arrays.asList("a", "d");
        System.out.println(first);
        System.out.println(second);
        System.out.println(sL.stringListsUnion(first, second));

//        System.out.println(sL);

    }
}
