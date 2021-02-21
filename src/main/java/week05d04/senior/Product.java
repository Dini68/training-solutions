package week05d04.senior;

public class Product {


    private long price;

    private Currency currency;

    public Product(long price, Currency currency) {
        this.price = price;
        if (currency == null) {
            throw new IllegalArgumentException("currency is null");
        }
        this.currency = currency;
    }

    public long getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double convertPrice(Currency currency) {
        if (this.currency == Currency.HUF) {
            if (currency == Currency.USD) {
                return price / 300.0;
            }
        }
        if (this.currency == Currency.USD) {
            if (currency == Currency.HUF) {
                return price * 300.0;
            }
        }
        return price;
    }

    public static void main(String[] args) {
        System.out.println(new Product(150, Currency.HUF).convertPrice(Currency.USD));
        System.out.println(new Product(150, Currency.USD).convertPrice(Currency.USD));
        System.out.println(new Product(150, Currency.USD).convertPrice(Currency.HUF));
        System.out.println(new Product(150, Currency.HUF).convertPrice(Currency.HUF));
    }
}
