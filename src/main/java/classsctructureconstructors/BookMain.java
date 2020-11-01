package classsctructureconstructors;

import java.util.Scanner;

public class BookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        Book book = new Book(author, title);

        System.out.print("Registry number: ");
        book.register(scanner.nextLine());

        System.out.println(book.getAuthor() + " " + book.getTitle() + " " + book.getRegNumber());
    }
}
