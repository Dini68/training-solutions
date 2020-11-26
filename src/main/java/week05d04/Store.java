package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();



    public boolean addProduct(Product product) {
        boolean isGoodProduct = true;
        if (product.getExpirationDate().isBefore(LocalDate.now())){
            isGoodProduct = false;
        }
        if (isGoodProduct) {
            for (Product p : products ) {
                if (p.getName().equals(product.getName())) {
                    isGoodProduct = false;
                    return isGoodProduct;
                }
            }
            products.add(product);
        }
        return isGoodProduct;
    }

    public int getNumberOfNonExpired(List<Product> products) {
        int count = 0;
        for (Product p: products
             ) {
            if (p.getExpirationDate().isAfter(LocalDate.now())) {
                System.out.println(p.getName() + " " + p.getExpirationDate());
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Store store = new Store();
        System.out.println(store.addProduct(new Product("tej", 2020, 12, 03)));
        System.out.println(store.addProduct(new Product("vaj", 2020, 11, 03)));
        store.addProduct(new Product("csirkemell", 2020, 11, 28));
        store.addProduct(new Product("csokoládé", 2021, 11, 03));
        System.out.println(store.addProduct(new Product("tej", 2020, 11, 27)));
        store.addProduct(new Product("teavaj", 2020, 11, 25));
        store.addProduct(new Product("csirkemell", 2020, 11, 30));
        store.addProduct(new Product("tea", 2021, 10, 03));
        System.out.println(store.getNumberOfNonExpired(store.products));
    }
}

