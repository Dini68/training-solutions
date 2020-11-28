package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Duplicates {

     public List<Integer> findDuplicates(List<Integer> integerList) {
         List<Integer> multipleItems = new ArrayList<>();
         for (int i = 0; i < integerList.size(); i++) {
             for (int j = 0; j < i ; j++) {
                 if (integerList.get(i) == integerList.get(j)) {
                     if (!multipleItems.contains(integerList.get(i))) {
                         multipleItems.add(integerList.get(i));
                     }
                 }
             }
         }
         return multipleItems;
     }

    public static void main(String[] args) {

         Duplicates duplicates = new Duplicates();
        System.out.println(duplicates.findDuplicates(Arrays.asList(1,2,2,1,2,23,3,3,4,5,4,1,2,3)));

    }
}
