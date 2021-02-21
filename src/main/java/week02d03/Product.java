package week02d03;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public boolean areTheyEqual(Product product) {
        return this.name.equals(product.name);
    }

    public static void main(String[] args) {
        Product product = new Product("Honor20", "1122");
        Product product2 = new Product("Honor20", "1128");
        Product product3 = new Product("Honor8", "1428");

        System.out.println(product.areTheyEqual(product2));
        System.out.println(product.areTheyEqual(product3));

    }
}
