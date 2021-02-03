package week14d02.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class OnlineShopping {

    public static void main(String[] args) {
        OnlineShopping os = new OnlineShopping();
        os.readFileToMap("shopping_list.txt");
        System.out.println(os.shoppingList);

        System.out.println(os.sumPriceById("112"));
        System.out.println(os.sumPriceByCustomer("GT23"));

        System.out.println(os.productsABCById("120", "name"));
        System.out.println(os.productsABCById("120", "price"));

        System.out.println(os.sumProduct("bread"));
        System.out.println(os.stat());

        System.out.println(os.shoppingList);
    }

    private Map<String, String> idList = new LinkedHashMap<>();
    private Map<String, Integer> products = new LinkedHashMap<>();
    private Map<String, Map<String, Integer>> shoppingList = new LinkedHashMap<>();

    public void readFileToMap(String fileName) {
        Path path = Path.of("src/main/java/week14d02/senior/" + fileName);
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line;
            String customer;
            String shoppingId;
            String product;
            int price;

            while ((line = br.readLine()) != null) {
                int poz = line.indexOf(':');
                customer = line.substring(0, poz).split("-")[0];
                shoppingId = line.substring(0, poz).split("-")[1];
                idList.put(shoppingId, customer);
                List<String> temp = Arrays.asList(line.substring(poz + 2).split(","));
                for(String s: temp) {
                    product = s.substring(0, s.indexOf("("));
                    price = Integer.parseInt(s.substring(s.indexOf("(") + 1, s.indexOf(")")));
                    products.put(product, price);
                }
                shoppingList.put(shoppingId, new LinkedHashMap<>(products));
                products.clear();
            }
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

    private int sumPriceById (String Id) {
        int sumPriceId = 0;
        for(Integer price: shoppingList.get(Id).values()) {
            sumPriceId += price;
        }
        return sumPriceId;
    }

    private int sumPriceByCustomer (String Customer) {
        int sumPriceCustomer = 0;
        for(String k: idList.keySet()) {
            if (idList.get(k).equals(Customer)) {
                sumPriceCustomer += sumPriceById(k);
            }
        }
        return sumPriceCustomer;
    }

    private Map<String, Integer> productsABCById (String Id, String option) {
        if (option.equals("name")) {
            Map<String, Integer> result = new LinkedHashMap<>();
            List<String> items = new ArrayList<>(shoppingList.get(Id).keySet());
            Collections.sort(items);
            for (String s : items) {
                result.put(s, shoppingList.get(Id).get(s));
            }
            return result;
        }
        if (option.equals("price")) {
            Map<Integer, String> temp = new LinkedHashMap<>();
            Map<String, Integer> result = new LinkedHashMap<>();
            for (String s: shoppingList.get(Id).keySet()) {
                temp.put(shoppingList.get(Id).get(s), s);
            }

            List<Integer> prices = new ArrayList<>(temp.keySet());
            Collections.sort(prices);
            for (int pr : prices) {
                for(String k: shoppingList.get(Id).keySet()) {
                    if (shoppingList.get(Id).get(k) == pr) {
                        result.put(k, pr);
                    }
                }
            }
            return result;
        }
        throw new IllegalArgumentException("no such.");
    }

    public int sumProduct(String Item) {
        int sumProduct = 0;
        for (String k : shoppingList.keySet()) {
            if (shoppingList.get(k).keySet().contains(Item)) {
                sumProduct ++;
            }
        }
        return sumProduct;
    }

    public Map<String, Integer> stat () {
        Map<String, Integer> statProduct = new LinkedHashMap<>();
        TreeSet<String> products = new TreeSet<>();
        for (String k : shoppingList.keySet()) {
            for (String p : shoppingList.get(k).keySet()) {
                products.add(p);
            }
        }
        for (String s: products) {
            statProduct.put(s, sumProduct(s));
        }
        return statProduct;
    }
}

//    A következő feladatban online bevásárlással kapcsolatos staisztikákat kell megoldani.
//        Minden vásárlás a következőképpen épül fel.
//        Vásárló egyedi azonosítója, a vásárlás egyedi azonosítója
//        majd a rendelt termékek, melyek után zárójelben szerepel azok ára.
//        Ezeket egy fájlban tároljuk.
//        Adatok:
//        ```
//        BK123-1211: bread(200),soda(120),carrot(320)
//        RA22-112: tomato(300),sugar(100),salt(100),chocolate(200)
//        BK123-111: beer(300),chips(250),potato(300)
//        RA22-1145: peas(300),yoghurt(200),milk(200),chicken(1300),bread(200)
//        SM123-11: pork_belly(1200),ketchup(800),corn(250),aluminium_foil(300)
//        GT23-011: bread(200),tomato(300),salt(100)
//        RA22-01112: salami(300),sour_cream(250)
//        SM123-120: dogfood(900),potato(300),tomato(200),chicken(1300),fish(3000),tuna(1200),pasta(200)
//        BK123-567: corn(200),jam(800),Nutella(1200),cereal(1200)
//        ```
//        A fájlban egy vásárlóhoz több rendelés is tartozhat. Olvasd be és tárold el a memóriában az adatokat. Fontos, hogy a webáruház ismerje a vásárlóit a vásárlók pedig ismerjék összes vásárlásukat. A fájlban a vásárlások időrendi sorrendben szerepelnek egyénenként. Tehát mindig a legújabb vásárlás van legelöl a listában.
//        Oldd meg az alábbi feladatokat:
//        1. Készíts egy metódust, ami visszaadja vásárlási azonosító alapján az adott vásárlás összértékét.
//        2. Készíts egy metódust, ami egy vásárló alapján visszaadja, hogy az adott vásárló mennyit pénzt költött eddig összesen a webáruházban.
//        3. Készíts egy metódus, ami a vásárlónak ABC sorrendbe rendezi egy vásárláson belül a termékeket, vásárlás azonosító alapján. (Bónusz: megoldhatod úgy, hogy vagy név vagy ár alapján rendezze annak megfelelően, hogy hogyan hívjuk a metódust.) Fontos, hogy ne rendezzük át az eredeti listát egy másolatot rendezzünk és azt adjuk vissza.
//        4. Készíts egy metódust, ami visszaadja, adott termék neve alapján, hogy összesen hányat rendeletek belőle a fájl alapján.
//        5. Készíts statisztikát a rendelt termékekből. Tárold el a termékeket és azt, hogy összesen hány darabot rendeltek belőle.
