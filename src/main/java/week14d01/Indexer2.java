package week14d01;

import java.util.*;

public class Indexer2 {

    public Map<Character, List<String>> index2(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        List<String> temp = new ArrayList<>();
        for (String s: names) {
            if (!result.containsKey(s.charAt(0))) {
                result.put(s.charAt(0), new ArrayList<>());
            }
            result.get(s.charAt(0)).add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        Indexer2 ind2  = new Indexer2();
        Map<Character, List<String>> expected = new HashMap<>();
        expected = ind2. index2(Arrays.asList("John", "Lujza", "Magdolna", "Jack",
                "Jane", "Leo", "Manci"));
        System.out.println(expected);
        System.out.println(expected.size());
        System.out.println(expected.isEmpty());
        System.out.println(expected.put('K', Arrays.asList("Kiss", "Kovács")));
        System.out.println(expected);
        System.out.println(expected.remove('J'));
        System.out.println(expected);
        System.out.println(expected.containsKey('M'));
        System.out.println(expected.containsValue(Arrays.asList("Magdolna","Manci")));
        System.out.println(expected.entrySet());
        System.out.println(expected.keySet());
        System.out.println(expected.values());
        for (Map.Entry<Character, List<String>> me : expected.entrySet()) {
            if (me.getKey() == 'K') {
                System.out.println(me);
            }
            if (me.getValue().get(0).equals("Lujza")) {
                System.out.println(me);
            }
        }
        for (Character c : expected.keySet()) {
            System.out.println(c);
        }
        for (List<String> l : expected.values()) {
            System.out.println(l);
        }
    }
}
