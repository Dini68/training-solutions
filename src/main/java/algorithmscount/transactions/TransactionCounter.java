package algorithmscount.transactions;

import java.util.List;

public class TransactionCounter {

    public int transactionCounterUpperLimit (List<Transaction> transactions, int upperLimit) {
        int count = 0;
        for (Transaction tr: transactions) {
            if (tr.getAmount() < upperLimit) {
                count ++;
            }
        }
        return count;
    }
}
