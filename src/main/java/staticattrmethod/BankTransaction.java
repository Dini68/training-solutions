package staticattrmethod;

import java.math.BigDecimal;

public class BankTransaction {

    private long trxValue;

    public static void initTheDay(){

    }
    public static BigDecimal averageOfTransaction() {
        return new BigDecimal(1);
    }
    public static long getCurrentMinValue() {
        return 1;
    }
    public static long getCurrentMaxValue() {
        return 1;
    }
    public static BigDecimal getSumOfTrxs() {
        return new BigDecimal(1);
    }

    public BankTransaction(long trxValue) {
        this.trxValue = trxValue;
    }
}
