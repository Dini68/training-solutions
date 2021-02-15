package week13d05.mid;

import java.util.HashSet;
import java.util.Set;

public class LetterCounter2 {

    public int differentLettersNumberInWord (String word){
        Set<Character> letters = new HashSet<>();
        for (char ch: word.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                letters.add(ch);
            }
        }
        return letters.size();
    }

    public static void main(String[] args) {
        LetterCounter2 lc = new LetterCounter2();
        System.out.println(lc.differentLettersNumberInWord("Courses is not exist"));
    }
}
