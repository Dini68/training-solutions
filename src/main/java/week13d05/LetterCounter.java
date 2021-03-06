package week13d05;

import java.util.HashSet;
import java.util.Set;

public class LetterCounter {

    public int numberOfDifferentLettersInWord(String word) {
        checkedValidWord(word);
        Set<Character> differentLetters = new HashSet<>();
        for (char ch: word.toLowerCase().toCharArray()) {
            if (isValidCharacter(ch)) {
                differentLetters.add(ch);
            }
        }
        return differentLetters.size();
    }

    private void checkedValidWord(String word) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("no such word");
        }
    }

    private boolean isValidCharacter(Character ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    public static void main(String[] args) {
        LetterCounter lc = new LetterCounter();
        System.out.println(lc.numberOfDifferentLettersInWord("Alma 112Ft"));
    }
}
