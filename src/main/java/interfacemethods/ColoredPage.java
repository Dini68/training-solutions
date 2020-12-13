package interfacemethods;

public class ColoredPage {

    private String pageContent;

    private String coloredPage;

    public ColoredPage(String pageContent, String coloredPage) {
        this.pageContent = pageContent;
        this.coloredPage = coloredPage;
    }

    public ColoredPage(String pageContent) {
        this.pageContent = pageContent;
        this.coloredPage = Printable.BLACK;
    }

    public String getPageContent() {
        return pageContent;
    }

    public String getColoredPage() {
        return coloredPage;
    }
}
