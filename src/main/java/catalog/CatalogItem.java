package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem{

    private String registrationNumber;

    private int price;

    private List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features = Arrays.asList(features);
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
        List<String> contributors = new ArrayList<>();
        for (Feature fe: features) {
            for (String str: fe.getContributors()) {
                contributors.add(str);
            }
        }
        return contributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature fe: features) {
            titles.add(fe.getTitle());
        }
        return titles;
    }

    public int fullLengthAtOneItem() {
        int fullLength = 0;
        for (Feature fe: features) {
            if(fe instanceof AudioFeatures) {
                AudioFeatures af = (AudioFeatures) fe;
                fullLength += af.getLength();
                // itt mar elered azt a metodust
            }
        }
        return fullLength; //??
    }
    public boolean hasAudioFeature() {
        boolean has = false;
        for (Feature fe: features) {
            if (fe instanceof AudioFeatures){
                has = true;
            }
        }
        return has; //?
    }
    public boolean hasPrintedFeature() {
        boolean has = false;
        for (Feature fe: features) {
            if (fe instanceof PrintedFeatures){
                has = true;
            }
        }
        return has; //?
    }
    public int numberOfPagesAtOneItem() {
        int numberOfPages = 0;
        for (Feature fe: features) {
            if(fe instanceof PrintedFeatures) {
                PrintedFeatures pf = (PrintedFeatures) fe;
                numberOfPages += pf.getNumberOfPages();
                // itt mar elered azt a metodust
            }
        }
        return numberOfPages; //??
    }
}
