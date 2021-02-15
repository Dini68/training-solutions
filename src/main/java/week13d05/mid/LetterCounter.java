package week13d05.mid;

import java.util.HashSet;
import java.util.Set;

public class LetterCounter {

    public int differentLettersNumberInWord (String word){
        String englishABC = "abcdefghijklmnopqrstuvxywz";
        Set<String> letters = new HashSet<>();
        for (String s: word.toLowerCase().split("")) {
            if (englishABC.contains(s)) {
                letters.add(s);
            }
        }
        return letters.size();
    }

    public static void main(String[] args) {
        LetterCounter lc = new LetterCounter();
        System.out.println(lc.differentLettersNumberInWord("courses is not exist"));
    }
}
