package introinheritance.itembasketshoppingbasket;

public class ShoppingBasket extends Basket{

    private Basket basket;

//    @Override
    public void addItem(Item item) {
        super.addItem(item);
    }

//    @Override
    public void removeItem(String barcode) {
        super.removeItem(barcode);
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
        super.clearBasket();
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
}
