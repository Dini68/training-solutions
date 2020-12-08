package introinheritance.itembasketshoppingbasket;

public class Item {

    private String barcode;

    private double nettoPrice;

    private int vatPercent;

    public double getTaxAmount() {
        return nettoPrice * vatPercent / 100.0;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
