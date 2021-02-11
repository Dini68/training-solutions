package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Statik {

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

    private Statik() {
        USED_CHARACTERS = HUNGARY_ABC_AND_DIGITS;
    }

    public Statik(String used_characters) {
        USED_CHARACTERS = used_characters;
    }

    public Statik(char... extraChar) {
        USED_CHARACTERS = HUNGARY_ABC_AND_DIGITS + new String(extraChar);
    }

    public Statik(String used_characters, char... extraChar) {
        USED_CHARACTERS = used_characters + new String(extraChar);
    }

    public void readFromFileToLines (String path, char... extraChar) {
        database.clear();
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))){
            String line;
            line = br.readLine();
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

    public List<String> foundMaxCovidNumberPerWeekByCountry (String country) {
        List<String> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int count = 0;
        for (int key: database.keySet()) {
            if (database.get(key).get(7).equals(country)) {
                temp.add(Integer.parseInt(database.get(key).get(5)));
                count++;
            }
        }
        Collections.sort(temp);
        int max = temp.get(temp.size()-3);
        for (int key: database.keySet()) {
            if (database.get(key).get(7).equals(country)) {
                if (Integer.parseInt(database.get(key).get(5)) == max) {
                    result.add(database.get(key).get(3)+"-"+database.get(key).get(4)
                    +"-"+database.get(key).get(5));
                }
            }
        }
        max = temp.get(temp.size()-2);
        for (int key: database.keySet()) {
            if (database.get(key).get(7).equals(country)) {
                if (Integer.parseInt(database.get(key).get(5)) == max) {
                    result.add(database.get(key).get(3)+"-"+database.get(key).get(4)
                            +"-"+database.get(key).get(5));
                }
            }
        }
        max = temp.get(temp.size()-1);
        for (int key: database.keySet()) {
            if (database.get(key).get(7).equals(country)) {
                if (Integer.parseInt(database.get(key).get(5)) == max) {
                    result.add(database.get(key).get(3)+"-"+database.get(key).get(4)
                            +"-"+database.get(key).get(5));
                }
            }
        }


//        System.out.println(temp);
//        System.out.println(count);
        return result;
    }

    public static void main(String[] args) {
        Statik ba = new Statik();
        ba.readFromFileToLines("src/main/java/week15d04/covid19.csv");
//        System.out.println(ba.getDatabase());
        System.out.println(ba.foundMaxCovidNumberPerWeekByCountry("Hungary"));
    }

}
