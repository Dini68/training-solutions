package controlselection.consonant;

import java.util.Arrays;
import java.util.List;

public class ToConsonant {

    public char convertToConsonant(char ch){
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        char newChar = ch;
        if (vowels.contains(ch)) {
            newChar++;
        }
        return newChar;
    }

    public static void main(String[] args) {
        ToConsonant toConsonant = new ToConsonant();
        System.out.println(toConsonant.convertToConsonant('a'));
    }
}
