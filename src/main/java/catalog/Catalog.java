package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog{

    public List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int number) {
        double average = 1;
        if (number < 1) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        int sumPages = 0;
        int item = 0;
        for (CatalogItem ci: catalogItems) {
            if (ci.numberOfPagesAtOneItem() > number) {
                sumPages += ci.numberOfPagesAtOneItem();
                item ++;
            }
        }

        if (sumPages == 0) {
            throw new IllegalArgumentException("No page");
        }
        average = sumPages / item;

        return average;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        CatalogItem findItem = null;
        for (CatalogItem ci: catalogItems) {
            if (ci.getRegistrationNumber().equals(registrationNumber)) {
                findItem = ci;
            }
        }
        if (!(findItem == null)) {
            catalogItems.remove(findItem);
        }
    }
    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria ) {
        List<CatalogItem> foundList = new ArrayList<>();

        boolean ready = false;
        if (searchCriteria.hasContributor() && searchCriteria.hasTitle()) {
            ready = true;
            for (CatalogItem ci: catalogItems) {
                if (ci.getContributors().contains(searchCriteria.getContributor()) &&
                    ci.getTitles().contains(searchCriteria.getTitle())) {
                    foundList.add(ci);
                }
            }
        }
        if (searchCriteria.hasContributor() && !ready)  {
            ready = true;
            for (CatalogItem ci: catalogItems) {
                if (ci.getContributors().contains(searchCriteria.getContributor())) {
                    foundList.add(ci);
                }
            }
        }
        if (searchCriteria.hasTitle() && !ready) {
            for (CatalogItem ci: catalogItems) {
                if (ci.getTitles().contains(searchCriteria.getTitle())) {
                    foundList.add(ci);
                }
            }
        }

        return foundList;
    }

    public int getAllPageNumber() {
        int allPageNumber = 0;
        for (CatalogItem ci: catalogItems) {
            allPageNumber += ci.numberOfPagesAtOneItem();
        }
        return allPageNumber;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioLibraryItems = new ArrayList<>();
        for (CatalogItem cItem : catalogItems) {
            if (cItem.hasAudioFeature()) {
                audioLibraryItems.add(cItem);
            }
        }
        return audioLibraryItems;
    }

    public int getFullLength() {
        int fullLength = 0;
        for (CatalogItem ci: catalogItems) {
            fullLength += ci.fullLengthAtOneItem();
        }
        return fullLength;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedLibraryItems = new ArrayList<>();
        for (CatalogItem cItem : catalogItems) {
            if (cItem.hasPrintedFeature()) {
                printedLibraryItems.add(cItem);
            }
        }
        return printedLibraryItems;
    }
}
