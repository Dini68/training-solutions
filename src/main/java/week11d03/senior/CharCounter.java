package week11d03.senior;

import java.util.Arrays;

public class CharCounter {

    private boolean isFindChar (String word, char c) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public int countChars(String[] chars) {
        if (chars == null || chars.length==0) {
            throw new IllegalArgumentException("Array is wrong");
        }
        int countChars = 0;
        boolean isFindCharAllChars;
        for (int j = 0; j < chars[0].length(); j++) {
            isFindCharAllChars = true;
            for (int i = 1; i < chars.length; i++) {
                if (isFindCharAllChars) {
                    isFindCharAllChars = isFindChar(chars[i], chars[0].charAt(j));
                }
            }
            if (isFindCharAllChars) {
                countChars++;
            }
        }
        return countChars;
    }
}
