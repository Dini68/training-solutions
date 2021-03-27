package week08d03.senior;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> shortestWords(List<String> words) {
        int minLength = getMinLength(words);
        return getShortestWords(words, minLength);
    }

    private int getMinLength(List<String> words) {
        int minLength = Integer.MAX_VALUE;
        for (String s: words) {
            if (minLength > s.length()) {
                minLength = s.length();
            }
        }
        return minLength;
    }

    private List<String> getShortestWords(List<String> words, int minLength) {
        List<String> shortestWords = new ArrayList<>();
        for (String s: words) {
            if (minLength == s.length()) {
                shortestWords.add(s);
            }
        }
        return shortestWords;
    }

    public static void main(String[] args) {
        StringLists sl = new StringLists();
        System.out.println(sl.shortestWords(List.of("aaa", "aa", "bb", "cccc", "dd")));
    }

}


