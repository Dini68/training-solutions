package methodstructure.pendrives;

public class Pendrive {

    private String name;

    private int capacity;

    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public void risePrice(int percent) {
        this.price = (int)Math.round(this.price * (100 + percent) / 100.0);
    }

    public int comparePricePerCapacity (Pendrive pendrive) {
        if (1.0 * price / capacity > 1.0 * pendrive.price / pendrive.capacity) {
            return 1;
        }
        if (1.0 * price / capacity == 1.0 * pendrive.price / pendrive.capacity) {
            return 0;
        }
        return -1;
    }

    public boolean cheaperThan(Pendrive pendrive) {
        return price < pendrive.price;
    }
}
