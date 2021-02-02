package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Basket {


    private Map<String, List<String>> products = new HashMap<>();

    public void readFileToMap(String fileName) {
        Path file = Path.of("src/main/java/week14d02/" + fileName);

        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                String id = line.substring(0, line.indexOf(" "));
                String b = line.substring(line.indexOf(" ") + 1);
                List<String> basket = Arrays.asList(b.split(","));
                products.put(id, basket);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }

    }

    public List<String> listBasket(String id) {
        List<String> result = new ArrayList<>();
        for (String k : products.keySet()) {
            if (id.equals(k)) {
                result = products.get(k);
            }
        }
        Collections.sort(result);
        return result;
    }


    public int countProduct(String name) {
        int counter = 0;
        for (String currentKey : products.keySet()) {
            if (products.get(currentKey).contains(name)) {
                counter++;
            }
        }
        return counter;
    }

    public int numberOfProductById (String id) {
        int number = 0;
        for(String k : products.keySet()) {
            if (k.equals(id)) {
                return products.get(k).size();
            }
        }
        throw new IllegalArgumentException("No such id");
    }

    public Map<String, Integer> stat() {
        TreeSet<String> items = new TreeSet<>();
        Map<String, Integer> statItem = new LinkedHashMap<>();
        for (List<String> list : products.values()) {
            for(String s: list) {
                items.add(s);
            }
        }
        for(String s: items) {
            statItem.put(s, countProduct(s));
        }
        return statItem;
    }

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.readFileToMap("shopping_list.txt");
        System.out.println(basket.listBasket("A312"));
        System.out.println(basket.countProduct("beer"));
        System.out.println(basket.numberOfProductById("W34111"));
        System.out.println(basket.stat().get("sugar"));
    }
}
