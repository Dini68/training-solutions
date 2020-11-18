package finalmodifier;

import java.util.Scanner;

public class TaxCalculator {

    public static final double AFA = 27;

    public double tax(double price) {
        return price * AFA / 100;
    }

    public double priceWithTax(double price) {
        return price + price * AFA / 100;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TaxCalculator taxCalculator = new TaxCalculator();

        System.out.print("Price : ");
        double price = scanner.nextDouble();

        System.out.println("ÁFA : " + taxCalculator.tax(price));
        System.out.println("ÁFÁ-val együtt: " + taxCalculator.priceWithTax(price));
    }
}
