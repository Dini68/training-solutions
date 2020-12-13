package interfacemethods;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable{

    private List<String> pageContents = new ArrayList<>();

    public void addPage(String content){
        pageContents.add(content);
    }

    @Override
    public int getLength() {
        return pageContents.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return pageContents.get(pageNumber);
    }
}
