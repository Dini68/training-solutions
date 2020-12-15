package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog{

    private List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }
    public double avaragePageNumberOver(int number) {

        if (getAllPageNumber() > number) {

        }
        return 1;
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
        return null; //??
    }
    public int getAllPageNumber() {
        int allPageNumber = 0;
        for (CatalogItem ci: catalogItems) {
            allPageNumber += ci.numberOfPagesAtOneItem();
        }
        return allPageNumber; //
    }
    public List<CatalogItem> getAudioLibraryItems() {
        return null; //??
    }
    public int getFullLength() {
        return 1; //??
    }
    public List<CatalogItem> getPrintedLibraryItems() {
        return null; //?
    }
}
