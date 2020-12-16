package catalog;

public class SearchCriteria {

    private String title;

    private String contributor;

    public SearchCriteria(String title, String contributor) {
        this.title = title;
        this.contributor = contributor;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (Validators.isBlank(title) || Validators.isBlank(contributor)) {
            throw new IllegalArgumentException();
        }
        SearchCriteria searchCriteria = new SearchCriteria(title, contributor);
        return searchCriteria;
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException();
        }
            SearchCriteria searchCriteria = new SearchCriteria("", contributor);
        return searchCriteria;
    }

    public static SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException();
        }
        SearchCriteria searchCriteria = new SearchCriteria(title, "");
        return searchCriteria;
    }

    public String getTitle() {
        return title;
    }

    public String getContributor() {
        return contributor;
    }

    public boolean hasContributor() {
        return !Validators.isBlank(contributor);
    }
    public boolean hasTitle() {
        return !Validators.isBlank(title);
    }
}
