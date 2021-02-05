package week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class CountWords {

    public static void main(String[] args) {
        CountWords cw = new CountWords();
        System.out.println(cw.countWords("hachiko.srt", "Hachiko", "haza", "pályaudvar", "jó"));
    }

    public Map<String, Integer> countWords(String fileName, String... words) {
        Map<String, Integer> result = new HashMap<>();
        initResult(result, words);
        Path path = Path.of("src/main/java/week14d05/" + fileName);
        try (BufferedReader br = Files.newBufferedReader(path)){
            return process(result, br, words);
        } catch (IOException e) {
            throw new IllegalStateException("not read file.", e);
        }
    }

    private Map<String, Integer> process(Map<String, Integer> result, BufferedReader br, String[] words) throws IOException {
        String line;
        while (null != (line = br.readLine())) {
            findWord(result, line, words);
        }
        return result;
    }

    private void initResult(Map<String, Integer> result, String[] words) {
        for (String word : words) {
            result.put(word, 0);
        }
    }

    private void findWord(Map<String, Integer> result, String line, String[] words) {
        int value;
        for (String word : words) {
            if (line.toLowerCase().contains(word.toLowerCase())) {
                value = result.get(word) + 1;
                result.put(word, value);
            }
        }
    }
}

//    A examples/week14d05/hachiko.srt van a Hachiko film felirata. Írj egy
//        countWords() metódust, mely paraméterül várja a fájlt, varargsban
//        szavakat. Megszámolja, hogy melyik szó hány sorban szerepel a
//        szövegben. Legyenek mondjuk a beadott szavak: "Hachiko", "haza",
//        "pályaudvar", "jó"