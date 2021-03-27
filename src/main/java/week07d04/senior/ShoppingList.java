package week07d04.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShoppingList {

    public static final String LINE_SEPARATOR = ";";
    public static final int INDEX_OF_AMOUNT = 1;
    public static final int INDEX_OF_PRICE = 2;

    public long calculateSum(String path) {
        long sum = 0;
        Path file = Path.of(path);
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                long result = calculateLineSum(line);
                sum += result;
            }
            return sum;
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private long calculateLineSum(String line) {
        String[] parts = line.split(LINE_SEPARATOR);
        long amount = Long.parseLong(parts[INDEX_OF_AMOUNT]);
        long price = Long.parseLong(parts[INDEX_OF_PRICE]);
        long result = amount * price;
        return result;
    }

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        System.out.println(shoppingList.calculateSum("src/main/java/week07d04/senior/shoppinglist.txt"));

    }
}
