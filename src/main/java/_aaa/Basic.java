package _aaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Basic {

    private final Map<Integer, List<String>> database = new LinkedHashMap<>();

    public Map<Integer, List<String>> getDatabase() {
        return new LinkedHashMap<>(database);
    }

    private final static String ENGLISH_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private final static String HUNGARY_LOWERCASE = ENGLISH_LOWERCASE + "áéíóöőúüű";
    private final static String ENGLISH_ABC = ENGLISH_LOWERCASE + ENGLISH_LOWERCASE.toUpperCase();
    private final static String HUNGARY_ABC = HUNGARY_LOWERCASE + HUNGARY_LOWERCASE.toUpperCase();
    private final static String DIGITS = "0123456789";
    private final static String HUNGARY_ABC_AND_DIGITS = HUNGARY_ABC + DIGITS;
    private final static String ENGLISH_ABC_AND_DIGITS = ENGLISH_ABC + DIGITS;

    private final String USED_CHARACTERS;

     private Basic() {
        USED_CHARACTERS = HUNGARY_ABC_AND_DIGITS;
    }

    public Basic(String used_characters) {
        USED_CHARACTERS = used_characters;
    }

    public Basic(char... extraChar) {
        USED_CHARACTERS = HUNGARY_ABC_AND_DIGITS + new String(extraChar);
    }

    public Basic(String used_characters, char... extraChar) {
        USED_CHARACTERS = used_characters + new String(extraChar);
    }

    public void readFromFileToLines (String path, char... extraChar) {
        database.clear();
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))){
            String line;
            int serialNumber = 0;
            while ((line = br.readLine()) != null) {
                processLine(serialNumber, line, extraChar);
                serialNumber++;
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    private void processLine(int serialNumber, String line, char... extraChar) {
        String extra = new String(extraChar);
        List<String> elements = new ArrayList<>();
        StringBuilder characters = new StringBuilder();
        for (String s : (line + "Đ").split("")) {
            if ((USED_CHARACTERS + extra).contains(s)) {
                characters.append(s);
            }
            else {
                if (characters.length() > 0) {
                    elements.add(characters.toString());
                }
                characters = new StringBuilder();
            }
        }
        database.put(serialNumber, elements);
    }

    public static void main(String[] args) {
        Basic ba = new Basic();
    }

}
