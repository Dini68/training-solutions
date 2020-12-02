package filescanner.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void loadFromFile() {
        try (Scanner scanner = new Scanner(Library.class.getResourceAsStream("/books.csv"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] temp = row.split(";");
                books.add(new Book(temp[0],temp[1],temp[2],Integer.parseInt(temp[3])));
            }
        }

    }


    public List<Book> getBooks() {
        return books;
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.loadFromFile();
        for (Book b: library.books) {
            System.out.println(b.getRegNum() + "  " + b.getAuthor() + ": " + b.getTitle() + "  /" + b.getYearOfPublish());
        }
    }
}
