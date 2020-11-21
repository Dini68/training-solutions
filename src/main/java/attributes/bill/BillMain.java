package attributes.bill;

public class BillMain {

    public static void main(String[] args) {

        Item item1 = new Item("Játékmackó", 20, 3_500);
        Item item2 = new Item("Star Wars Lego", 10, 12_000);
        Item item3 = new Item("Pöttyös labda", 38, 1_700);

        Bill bill = new Bill();

        bill.addItem(item1);
        bill.addItem(item2);
        bill.addItem(item3);

        bill.calculateTotalPrice();
    }
}
