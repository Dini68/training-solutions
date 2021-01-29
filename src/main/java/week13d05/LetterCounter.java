package week13d05;

import java.util.HashSet;
import java.util.Set;

public class LetterCounter {

    private void isValidWord(String word) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("no such word");
        }
    }

    private boolean isValidCharacter(Character ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    public int numberOfDifferentLettersInWord(String word) {
        isValidWord(word);
        Set<Character> differentLetters = new HashSet<>();
        Character ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.toLowerCase().charAt(i);
            if (isValidCharacter(ch)) {
                differentLetters.add(ch);
            }
        }
        return differentLetters.size();
    }

    public static void main(String[] args) {
        LetterCounter lc = new LetterCounter();
        System.out.println(lc.numberOfDifferentLettersInWord("Alma 112Ft"));
    }
}
