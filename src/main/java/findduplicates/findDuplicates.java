package findduplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findDuplicates {


        public static void main(String[] args) {

            List<Integer> i = Arrays.asList(1, 2, 3, 3, 4, 3, 2);

            System.out.println("Elemek: " + i.toString());

            List<Integer> doubleElements = new ArrayList<>() ;

            for (int j = 0; j < i.size(); j++) {
                for (int k = j+1; k < i.size(); k++) {
                    if (!doubleElements.contains(i.get(j)) && (i.get(j) == i.get(k))) {
                        doubleElements.add(i.get(j));
                        break;
                    }
                }
            }
            System.out.println(doubleElements);

        }

}
