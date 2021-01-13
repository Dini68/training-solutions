package week11d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldFilter {

    public List<String> wordsWithChar(List<String> words, char c) {
        if (words == null) {
            throw new IllegalArgumentException("Null cannot be param");
        }
        List<String> result = new ArrayList<>();
        boolean isCorrect;
        for (String word: words) {
            isCorrect = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    isCorrect = true;
                }
            }
            if(isCorrect) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((new WorldFilter().wordsWithChar(Arrays.asList("klékl","ékku","ztuz","fhg","ttzk"),'k')));
    }

}
