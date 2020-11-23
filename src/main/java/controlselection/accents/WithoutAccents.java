package controlselection.accents;

import java.util.Arrays;
import java.util.List;

public class WithoutAccents {

    public char convertToCharWithoutAccents(char ch){
        switch (ch){
            case 'á' : ch = 'a' ; break;
            case 'é' : ch = 'e' ; break;
            case 'í' : ch = 'i' ; break;
            case 'ó', 'ö', 'ő' : ch = 'o' ; break;
            case 'ú', 'ü', 'ű' : ch = 'u' ; break;
            case 'Á' : ch = 'A' ; break;
            case 'É' : ch = 'E' ; break;
            case 'Í' : ch = 'I' ; break;
            case 'Ó', 'Ö', 'Ő' : ch = 'O' ; break;
            case 'Ú', 'Ü', 'Ű' : ch = 'U' ; break;
        }
        return ch;
    }

    public static void main(String[] args) {

        WithoutAccents toConsonant = new WithoutAccents();
        System.out.println(toConsonant.convertToCharWithoutAccents('á'));
    }
}
