package attributes.book;

public class BookMain {

    public static void main(String[] args) {

        Book book = new Book("Egri Csillagok");

        System.out.println(book.getTitle());

        book.setTitle("Pál utcai fiúk");

        System.out.println(book.getTitle());
    }
}
