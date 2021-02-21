package week04d02;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<Integer> getIndexesOfChar(String text, char ch) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        for (char c : text.toCharArray()) {
            if (c == ch) {
                result.add(i);
            }
            i ++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Search().getIndexesOfChar("hatalmas", 'a'));
    }
}
