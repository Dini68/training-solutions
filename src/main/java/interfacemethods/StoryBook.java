package interfacemethods;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable{

    private List<ColoredPage> coloredPages = new ArrayList<>();


    @Override
    public int getLength() {
        return coloredPages.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return coloredPages.get(pageNumber).getPageContent();
    }

    @Override
    public String getColor(int pageNumber) {
        return coloredPages.get(pageNumber).getColoredPage();
    }

    public void addPage(String page, String color) {
        coloredPages.add(new ColoredPage(page, color));
    }
}
