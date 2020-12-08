package introinheritance.itembasketshoppingbasket;

public class ShoppingBasket{

    private Basket basket = new Basket();


    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        int sumNP = 0;
        for (Item i: basket.getItems()) {
            sumNP += i.getNettoPrice();
        }
        return sumNP;
    }
    public double sumTaxValue() {
        int sumTV = 0;
        for (Item i: basket.getItems()) {
            sumTV += i.getTaxAmount();
        }
        return sumTV;
    }
    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        basket.clearBasket();
    }
    public void removeMostExpensiveItem() {
        String expensiveItem = "";
        double maxPrice = 0;
        for (Item it: basket.getItems()) {
            if (maxPrice < (it.getNettoPrice() + it.getTaxAmount())) {
                maxPrice = (it.getNettoPrice() + it.getTaxAmount());
                expensiveItem = it.getBarcode();
            }
        }
        this.removeItem(expensiveItem);
    }

    public static void main(String[] args) {

        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.addItem(new Item("123456", 1500, 27));
        shoppingBasket.addItem(new Item("789456", 2500, 0));
        shoppingBasket.addItem(new Item("147258", 5000, 27));
        System.out.println(Math.round(shoppingBasket.sumNettoPrice()));
    }
}
