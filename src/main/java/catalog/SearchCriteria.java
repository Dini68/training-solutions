package catalog;

public class SearchCriteria {

    private String title;

    private String contributor;

    public SearchCriteria(String title, String contributor) {
        this.title = title;
        this.contributor = contributor;
    }
    public SearchCriteria createByBoth(String title, String contributor) {
        return null; //??
    }
    public SearchCriteria createContributor(String contributor) {
        return null; //??
    }
    public SearchCriteria createByTitle(String title) {
        return null; //??
    }

    public String getTitle() {
        return title;
    }

    public String getContributor() {
        return contributor;
    }
    public boolean hasContributor() {
        return false;
    }
    public boolean hasTitle() {
        return false;
    }
}
