package _aaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class  BasicProgram {


    private final static String EXTRA_CHARACTER = "";
    private final static String ENGLISH_LOWERCASE = "abcdefghijklmnopqrstuvwxyz" + EXTRA_CHARACTER;
    private final static String HUNGARY_LOWERCASE = ENGLISH_LOWERCASE + "áéíóöőúüű";
    private final static String ENGLISH_ABC = ENGLISH_LOWERCASE + ENGLISH_LOWERCASE.toUpperCase();
    private final static String HUNGARY_ABC = HUNGARY_LOWERCASE + HUNGARY_LOWERCASE.toUpperCase();
    private final static String DIGITS = "0123456789";
    private final static String HUNGARY_ABC_AND_DIGITS = HUNGARY_ABC + DIGITS;
    private final static String ENGLISH_ABC_AND_DIGITS = ENGLISH_ABC + DIGITS;

    private final Map<Integer, List<String>> database = new LinkedHashMap<>();

    public Map<Integer, List<String>> getDatabase() {
        return new LinkedHashMap<>(database);
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
            if ((HUNGARY_ABC_AND_DIGITS + extra).contains(s)) {
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

    public int lastNumberOfHouse () {
        int oddNumber = -1;
        int evenNumber = 0;
        for (int key: getDatabase().keySet()) {
            if (getDatabase().get(key).get(0).equals("0")) {
                evenNumber += 2;
            }
            if (getDatabase().get(key).get(0).equals("1")) {
                oddNumber += 2;
            }
        }
        return Math.max(oddNumber, evenNumber);
    }

    public String longestNamedCity () {
        int maxLength = 0;
        String name = "";
        for (int key: getDatabase().keySet()) {
            for(String s: getDatabase().get(key)) {
                if (s.length() > maxLength) {
                    maxLength = s.length();
                    name = s;
                }
            }
        }
        return name;
    }

    public String shortestNamedCity () {
        int minLength = 100;
        String name = "";
        for (int key: getDatabase().keySet()) {
            for(String s: getDatabase().get(key)) {
                if (s.length() < minLength) {
                    minLength = s.length();
                    name = s;
                    if (s.equals("d")) {
                        System.out.println(key);
                    }
                }
            }
        }

        return name;
    }

    public List<String> specifiedLetterNamedCity (int letterNumber) {
        List<String> names = new ArrayList<>();
        for (int key: getDatabase().keySet()) {
            if (key != 0) {
                for (int i = 1; i < getDatabase().get(key).size(); i++) {
                    if (getDatabase().get(key).get(i).length() == letterNumber) {
                        names.add(getDatabase().get(key).get(i));
                    }
                }
            }
        }
        return names;
    }

    public Map<String, Integer> wordCounterInFile(String... words) {
        Map<String, Integer> result = new LinkedHashMap<>();
        int count;
        boolean found;
        for (String word: words) {
            count = 0;
            for (int key : getDatabase().keySet()) {
                found = false;
                for (String s : getDatabase().get(key)) {
                    if (s.toLowerCase().equals(word)) {
                        if (!found) {
                            count++;
                        }
                        found = true;
                    }
                }
            }
            result.put(word, count);
        }
        return result;
    }

    public String foundCapitalBySate (String state) {
        for (int key: getDatabase().keySet()) {
            if (getDatabase().get(key).get(0).equals(state)) {
                return getDatabase().get(key).get(1);
            }
        }
        throw new IllegalArgumentException("No such state");
    }

    public String arrivalOrDepartureMore() {
        String result = "Departure";
        int count = 0;
        for (int key: getDatabase().keySet()) {
            if (getDatabase().get(key).get(1).equals("Arrival")) {
                count++;
            }
        }
        if (count > getDatabase().size() - count) {
            result = "Arrival";
        }
        if (count == getDatabase().size() - count) {
            result = "Equals.";
        }
        return result;
    }

    public String earliestDeparture () {
        StringBuilder result = new StringBuilder();
        List<String> value = new ArrayList<>();
        LocalTime earliestTime = LocalTime.of(23,59, 30);
        LocalTime actualTime = LocalTime.of(23,59);
        int resultKey = 0;
        int hour = 0;
        int minute = 0;
        for (int key: getDatabase().keySet()) {
            value = getDatabase().get(key);
            if (value.get(1).equals("Departure")) {
                hour = Integer.parseInt(value.get(3));
                minute = Integer.parseInt(value.get(4));
                actualTime = LocalTime.of(hour, minute);
                if (actualTime.isBefore(earliestTime)) {
                    earliestTime = actualTime;
                    resultKey = key;
                }
            }
        }
        for(String s: getDatabase().get(resultKey)) {
            result.append(s).append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        BasicProgram bp = new BasicProgram();
        bp.readFromFileToLines("src/main/resources/iranyitoszamok-varosok.csv",'û',' ');
        System.out.println(bp.getDatabase());
        System.out.println(bp.longestNamedCity());
        System.out.println(bp.shortestNamedCity());
        System.out.println(bp.specifiedLetterNamedCity(2));
        System.out.println(bp.specifiedLetterNamedCity(4));
        System.out.println(bp.specifiedLetterNamedCity(20));
        System.out.println(bp.specifiedLetterNamedCity(9));

        bp.readFromFileToLines("kerites.txt",':','#');
        System.out.println(bp.getDatabase());
        System.out.println(bp.lastNumberOfHouse());

        bp.readFromFileToLines("src/main/java/week14d05/hachiko.srt");
        System.out.println(bp.getDatabase());
        System.out.println(bp.wordCounterInFile("jó", "Hachiko", "pályaudvar", "haza"));

        bp.readFromFileToLines("src/main/resources/stateregister.txt", ' ');
        System.out.println(bp.getDatabase());
        System.out.println(bp.foundCapitalBySate("California"));

        bp.readFromFileToLines("cities.txt", '_');
        System.out.println(bp.getDatabase());
        System.out.println(bp.arrivalOrDepartureMore());
        System.out.println(bp.earliestDeparture());
    }
}
