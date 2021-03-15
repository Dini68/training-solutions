package week15d02.senior;

import _aaa.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private final Map<Integer, List<String>> database = new LinkedHashMap<>();

    public Map<Integer, List<String>> getDatabase() {
        return new LinkedHashMap<>(database);
    }


    private Map<Integer, List<String>> actualBase = new LinkedHashMap<>();

    public Map<Integer, List<String>> getActualBase() {
        return new LinkedHashMap<>(actualBase);
    }



    private final static String ENGLISH_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private final static String HUNGARY_LOWERCASE = ENGLISH_LOWERCASE + "áéíóöőúüű";
    private final static String ENGLISH_ABC = ENGLISH_LOWERCASE + ENGLISH_LOWERCASE.toUpperCase();
    private final static String HUNGARY_ABC = HUNGARY_LOWERCASE + HUNGARY_LOWERCASE.toUpperCase();
    private final static String DIGITS = "0123456789";
    private final static String HUNGARY_ABC_AND_DIGITS = HUNGARY_ABC + DIGITS;
    private final static String ENGLISH_ABC_AND_DIGITS = ENGLISH_ABC + DIGITS;

    private final String USED_CHARACTERS;

    private Orders() {
        USED_CHARACTERS = HUNGARY_ABC_AND_DIGITS;
    }

    public Orders(String used_characters) {
        USED_CHARACTERS = used_characters;
    }

    public Orders(char... extraChar) {
        USED_CHARACTERS = HUNGARY_ABC_AND_DIGITS + new String(extraChar);
    }

    public Orders(String used_characters, char... extraChar) {
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

    public void createActualBase () {
        List<String> actualLine = new ArrayList<>();
        String year = "";
        String month = "";
        String day = "";
        String hour = "";
        String minute = "";
        String postcode = "";
        String street = "";
        String numberOfHouse = "";
        String date = "";
        String time = "";
        String id = "";
        String address = "";
        for (int key: getDatabase().keySet()) {
            actualLine = getDatabase().get(key);
            if (actualLine.size() == 3) {
                year = (actualLine.get(0));
                month = (actualLine.get(1));
                day = (actualLine.get(2));
                date = year + "." + month + "." + day;
            }
            if (actualLine.size() == 1) {
                id = actualLine.get(0);
            }
            if (actualLine.size() == 5) {
                postcode = actualLine.get(0);
                street = actualLine.get(1);
                numberOfHouse = actualLine.get(2);
                address = postcode + " " + street + " " + numberOfHouse;
                hour = actualLine.get(3);
                minute = actualLine.get(4);
                time = hour + ":" + minute;
                actualBase.put(key, List.of(date, id, address, time));
            }
        }
    }

    public String minOrdersDate () {
        String result = "";
        int countOrders = 0;
        String previousDate = "";
        String actualDate = "";
        int minOrders = 1000;
        for (int key: getActualBase().keySet()) {
            actualDate = getActualBase().get(key).get(0);
            if (!actualDate.equals(previousDate)) {
                result = previousDate;
                previousDate = actualDate;
                if (minOrders > countOrders) {
                    minOrders = countOrders;
                    countOrders = 1;
                }
            }
            else {
                countOrders ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Orders or = new Orders();
        or.readFromFileToLines("src/main/java/week15d02/senior/orders.txt", '_');
        System.out.println(or.getDatabase());
        or.createActualBase();
        System.out.println(or.getActualBase());
        System.out.println(or.minOrdersDate());
    }

}
//    Adott egy fájl melyben pizza rendeléseket tárolunk. A fájl blokkokra van osztva,
//    egy blokk egy napot jelöl, és minden ilyen blokk egy dátummal kezdődik.
//    Ezután egy rendelés adatai két sorban találhatók. Az első sor a futár azonosítója,
//    a második sorban irányítószám, utcanév, házszám és a szállítás pontos ideje található.
//        ​
//        ```
//        2020.12.01
//        FUT_1
//        1113 Petőfi 12 12:30
//        FUT_2
//        1114 Kossuth 9 11:20
//        FUT_2
//        1211 Jókai 10 19:30
//        FUT_3
//        1191 Kossuth 9 18:12
//        FUT_1
//        1144 Tököly 11 16:33
//        2020.12.02
//        FUT_1
//        1123 Ady 12 12:30
//        ....
//        ```
//        ​
//        A fájl beolvasása után oldjátok meg a következő feladatokat!
//        1. Melyik napon volt a legkevesebb rendelés?
//        2. Egy metódus várjon paraméterül egy dátumot, pontos időponttal és
//        adjuk vissza a hozzá tartozó rendelést. Ha nincs ilyen akkor dobjunk kivételt.
//        (Vagy Optional)
//        3. Készíts statisztikát a futárok szállításiból, futáronként add vissza,
//        hogy mennyi rendelést teljesítettek.
//        4. Melyik címre szállították a legtöbb pizzát?
