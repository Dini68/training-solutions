package week06d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSelector {

    public String listSelector(List<String> list){
        if (list == null) {
            throw new IllegalArgumentException("Nincs lista");
        }
        String evenList = "[";
//        String oddList = "[";

        if (list.size() == 0) {
            evenList = "";
//            oddList = "[]";
        } else {
            int index = 0;
            for (String s : list) {
                if (index % 2 == 0) {
                    evenList += s;
                    if (index+2<list.size()){
                        evenList += ",";
                    }
                } else {
//                    oddList += s;
                }
                index++;
            }

            evenList += "]";
//            oddList += "]";
        }
        System.out.println(evenList);
//        System.out.println(oddList);
        return evenList;
    }

    public static void main(String[] args) {
         List<String> nullList = null;
        List<String> emptyList = new ArrayList<>();
        List<String> originalList = Arrays.asList(
                "alma",
                "körte",
                "szilva",
                "barack",
                "banán",
                "eper",
                "citrom");
        System.out.print(originalList + " -> ") ;
        ListSelector listSelector = new ListSelector();
        listSelector.listSelector(originalList);
        listSelector.listSelector(emptyList);
 //       listSelector.listSelector(nullList);
    }
}
