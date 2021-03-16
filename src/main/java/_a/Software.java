package _a;

public abstract class Software {

    protected String name;
    protected double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void increasePrice() {

    }

    public Software(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static void main(String[] args) {
    }
}
