package classstructuremethods;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Client client = new Client();

        System.out.print("Name: ");
        client.setName(scanner.nextLine());

        System.out.print("Year of birth: ");
        client.setYear(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Address: ");
        client.setAddress(scanner.nextLine());

        System.out.println(client.getName());
        System.out.println(client.getYear());
        System.out.println(client.getAddress());

        System.out.print("New address: ");

        client.migrate(scanner.nextLine());

        System.out.println("Modify is success. The new address: ");
        System.out.println(client.getAddress());
    }
}
