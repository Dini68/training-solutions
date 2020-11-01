package classsctructureconstructors;

import java.util.Scanner;

public class StoreMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Product: ");

        Store store = new Store(scanner.nextLine());

        System.out.print("Stock increase: ");

        store.store(scanner.nextInt());

        System.out.print("Stock decrease: ");

        store.dispatch(scanner.nextInt());

        System.out.println(store.getProduct() + " " + store.getStock());

    }

}
