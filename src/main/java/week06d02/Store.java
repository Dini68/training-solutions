package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products;

    public Store(List<Product> products) { // A konstruktorban kapja meg a listát.
        this.products = products;
    }

    public int getProductByCategoryName(Category category) {
        int count = 0;
        for (Product p: products) {
            if (p.getCategory() == category) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product("alma", Category.OTHER, 500);
        productList.add(product1);
        Product product2 = new Product("banán", Category.OTHER, 400);
        productList.add(product2);
        Product product4 = new Product("tej", Category.DAIRY, 200);
        productList.add(product4);
        Product product5 = new Product("vaj", Category.DAIRY, 350);
        productList.add(product5);
        Product product6 = new Product("kifli", Category.BAKEDGOODS, 40);
        productList.add(product6);
        Product product7 = new Product("tej", Category.FROZEN, 200);
        productList.add(product7);
        Product product8 = new Product("vaj", Category.FROZEN, 350);
        productList.add(product8);
        Product product9 = new Product("kifli", Category.FROZEN, 40);
        productList.add(product9);
        Store store = new Store(productList);
        System.out.println(store.getProductByCategoryName(Category.FROZEN));
        System.out.println(store.getProductByCategoryName(Category.DAIRY));
        System.out.println(store.getProductByCategoryName(Category.BAKEDGOODS));
        System.out.println(store.getProductByCategoryName(Category.OTHER));
    }
}
