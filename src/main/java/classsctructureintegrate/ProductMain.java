package classsctructureintegrate;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Product: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        int price = scanner.nextInt();

        Product product = new Product(name, price);
        System.out.println(product.getName() + ": " + product.getPrice() + " HUF");

        System.out.print("Increase: ");
        product.increasePrice(scanner.nextInt());

        System.out.println(product.getName() + ": " + product.getPrice() + " HUF");

        System.out.print("Decrease: ");
        product.decreasePrice(scanner.nextInt());

        System.out.println(product.getName() + ": " + product.getPrice() + " HUF");
    }
}
