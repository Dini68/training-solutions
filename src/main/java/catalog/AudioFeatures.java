package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{

    private String title;

    private int length;

    private List<String> performers;

    private List<String> composer;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (new Validators().isBlank(title)) {
            throw new IllegalArgumentException();
        }
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        if (new Validators().isEmpty(performers)) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (new Validators().isBlank(title)) {
            throw new IllegalArgumentException();
        }
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        if (new Validators().isEmpty(performers)) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = composer;
    }

    @Override
    public List<String> getContributors() {
        List<String > commonList = new ArrayList<>();
        if (new Validators().isEmpty(performers)) {
            throw new IllegalArgumentException();
        }
        if (!(new Validators().isEmpty(composer))) {
            for (String st: composer) {
                commonList.add(st);
            }
        }
        for (String st: performers) {
            commonList.add(st);
        }
        return commonList;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
