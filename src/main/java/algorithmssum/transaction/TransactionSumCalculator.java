package algorithmssum.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sumAmount = 0;
        for (Transaction tr: transactions) {
            if (tr.getTransactionOperation() == TransactionOperation.CREDIT) {
                sumAmount += tr.getAmount();
            }
            if (tr.getTransactionOperation() == TransactionOperation.DEBIT) {
                sumAmount -= tr.getAmount();
            }
        }
        return sumAmount;
    }
}
