package algorithmssum;

public class Salesperson {

    private String name;

    private int amount;

    public Salesperson(String name, int amount) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Nincs megadva név!");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Nem lehet negatív a bevétel!");
        }
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
}
