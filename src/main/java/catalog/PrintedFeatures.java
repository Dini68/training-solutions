package catalog;

import java.util.List;

public class PrintedFeatures implements Feature {

    private String title;

    private int numberOfPages;

    private List<String> authors;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (new Validators().isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (numberOfPages < 0) {
            throw new IllegalArgumentException();
        }
        if (new Validators().isEmpty(authors)) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public List<String> getContributors() {
        return authors;
    }
}
