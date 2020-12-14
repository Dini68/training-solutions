package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem implements Feature{

    private String registrationNumber;

    private int price;

    private List<Feature> features;

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

    @Override
    public List<String> getContributors() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
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
