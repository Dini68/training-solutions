package week07d04.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShoppingList {

    public long calculateSum(String path) {
        long sum = 0;
        Path file = Path.of(path);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            return getSum(sum, reader);
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private long getSum(long sum, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            int count = Integer.parseInt(line.split(";")[1]);
            int price = Integer.parseInt(line.split(";")[2]);
            sum += count * price;
        }
        return sum;
    }

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        System.out.println(shoppingList.calculateSum("src/main/java/week07d04/senior/shoppinglist.txt"));

    }
}
