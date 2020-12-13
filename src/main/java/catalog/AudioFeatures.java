package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{

    private String title;

    private int length;

    private List<String> performers;

    private List<String> composer;

    public AudioFeatures(String title, int length, List<String> performers) {
        this.title = title;
        this.length = length;
        this.performers = performers;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = composer;
    }

    @Override
    public List<String> getContributors() {
        // performers & composer list ???
        return composer;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
