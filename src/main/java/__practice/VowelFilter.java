package __practice;

import _aaa.variable.Flight;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VowelFilter {


    public String filterVowels(BufferedReader reader) {
        try {
            String line;
            StringBuilder sb = new StringBuilder();
            while((line = reader.readLine()) != null) {
                filterProcess(line, sb);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

    private void filterProcess(String line, StringBuilder sb) {
        String vowels = "aáeéiíoóöőuúüű";
        for (char c: line.toCharArray()) {
            if (!vowels.contains(Character.toString(c).toLowerCase())) {
                sb.append(c);
            }
            else {
                sb.append("e");
            }
        }
        sb.append("\n");
    }

    public static void main(String[] args) {
        Path path = Path.of("src/main/java/__practice/words.txt");
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)){
            System.out.println(new VowelFilter().filterVowels(bufferedReader));
        } catch (IOException e) {
            throw new IllegalStateException("can not read file.", e);
        }
    }
}
