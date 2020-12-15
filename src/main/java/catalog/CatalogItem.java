package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem{

    private String registrationNumber;

    private int price;

    private List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, List<Feature> features) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features = features;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public List<String> getContributors() {
        return null;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature fe: features) {
            titles.add(fe.getTitle());
        }
        return titles;
    }

    public int fullLengthAtOneItem() {
        return 1; // ??
    }
    public boolean hasAudioFeature() {
        return false; //?
    }
    public boolean hasPrintedFeature() {
        return false; //??
    }
    public int numberOfPagesAtOneItem() {
        return 1; //??
    }

}
