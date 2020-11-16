package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<String> titles = new ArrayList<>();

    public void add (String title) {
        titles.add(title);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> findTitles = new ArrayList<>();
        for (String title: titles
             ) {
            if (title.contains(prefix)) {
                findTitles.add(title);
            }
        }
        return findTitles;
    }

    public List<String> getTitles() {
        return titles;
    }

    public static void main(String[] args) {

        Books books = new Books();

        books.add("Egri Csillagok");
        books.add("Pál utcai fiúk");
        books.add("A kis herceg");

        System.out.println(books.getTitles());
        System.out.println(books.findAllByPrefix("kis"));
        System.out.println(books.findAllByPrefix("l"));
    }
}
