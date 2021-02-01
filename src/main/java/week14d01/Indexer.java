package week14d01;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        List<String> temp = new ArrayList<>();
        for (String s: names) {
            if (result.containsKey(s.charAt(0))) {
                temp = result.get(s.charAt(0));
                temp.add(s);
                result.put(s.charAt(0), temp);
            } else {
                temp = new ArrayList<>();
                temp.add(s);
                result.put(s.charAt(0), temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Indexer ind  = new Indexer();

        System.out.println(ind. index(Arrays.asList("John", "Lujza", "Magdolna", "Jack")));
    }
}
