package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {

    public static void main(String[] args) {
        new Book();

        System.out.println(new Book());

        Book emptyBook = null;

        System.out.println(emptyBook);

        System.out.println(emptyBook == null);

        Book book = new Book();

        System.out.println(book);

        book = null;

        System.out.println(book);

        book = new Book();

        System.out.println(book);

        Book anotherBook = new Book();

        System.out.println(book == anotherBook);

        System.out.println(anotherBook instanceof Book);

        Book[] books = new Book[3];

        List<Book> bookList = Arrays.asList(books);

        List<Book> emptyBookList = new ArrayList<>();

        emptyBookList.add(new Book());
        emptyBookList.add(new Book());
        emptyBookList.add(new Book());
    }
}
