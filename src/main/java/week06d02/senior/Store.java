package week06d02.senior;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public Store(List<Product> products) {
        this.products = products;
    }
    public List<NumberByCategory> getProductsByCategory () {
        List<NumberByCategory> result = new ArrayList<>();
        int[] numbers = new int[4];
        for (Product product: products) {
            if (product.getCategory() == Category.FROZEN) {
                numbers[0] ++;
            }
            if (product.getCategory() == Category.DAIRY) {
                numbers[1] ++;
            }
            if (product.getCategory() == Category.BAKED_GOODS) {
                numbers[2] ++;
            }
            if (product.getCategory() == Category.OTHER) {
                numbers[3] ++;
            }
        }
        result.add(new NumberByCategory(Category.FROZEN, numbers[0]));
        result.add(new NumberByCategory(Category.DAIRY, numbers[1]));
        result.add(new NumberByCategory(Category.BAKED_GOODS, numbers[2]));
        result.add(new NumberByCategory(Category.OTHER, numbers[3]));
        return result;
    }
}
//    public List<String> getProductsByCategory () {
//        List<String> result = new ArrayList<>();
//        int[] numbers = new int[4];
//        for (Product product: products) {
//            if (product.getCategory() == Category.FROZEN) {
//                numbers[0] ++;
//            }
//            if (product.getCategory() == Category.DAIRY) {
//                numbers[1] ++;
//            }
//            if (product.getCategory() == Category.BAKED_GOODS) {
//                numbers[2] ++;
//            }
//            if (product.getCategory() == Category.OTHER) {
//                numbers[3] ++;
//            }
//        }
//        result.add("FROZEN: " + numbers[0]);
//        result.add("DAIRY: " + numbers[1]);
//        result.add("FROZEN: " + numbers[2]);
//        result.add("FROZEN: " + numbers[3]);
//        return result;
//    }
