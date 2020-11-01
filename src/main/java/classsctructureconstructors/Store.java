package classsctructureconstructors;

public class Store {

    private String product;

    private int stock;

    public Store (String product) {
        this.product = product;
    }

    public int store (int stock) {
        return this.stock += stock;
    }

    public int dispatch (int stock) {
        return this.stock -= stock;
    }

    public String getProduct() {
        return product;
    }

    public int getStock() {
        return stock;
    }
}
