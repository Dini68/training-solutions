package week06d04;

public class Item {

    private int price;

    private int month;

    private String name;

    public Item(int price, int month, String name) {
        if ((name == null) || (name.equals(""))) {
            throw new IllegalArgumentException("Tétel nincs megadva");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Az ár nem lehet negatív");
        }
        if ((month < 1) || (month > 12)) {
            throw new IllegalArgumentException("Érvénytelen hónap");
        }

        this.price = price;
        this.month = month;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getMonth() {
        return month;
    }

    public String getName() {
        return name;
    }
}
