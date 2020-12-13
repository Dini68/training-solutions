package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog{

    private List<CatalogItem> catalogItems =new ArrayList<>();

    public void addItem(CatalogItem catalogItem){
        catalogItems.add(catalogItem);
    }
    public double avaragePageNumberOver(int number) {
        return 1;
    }
    public void deleteItemByRegistrationNumber(String registrationNumber) {
        //
    }
    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria ) {
        return null; //??
    }
    public int getAllPageNumber() {
        return 1; //
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
