package algorithmscount.transactions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransactionCounterTest {

    List<Transaction> transactions = Arrays.asList(
            new Transaction("100001",TransactionType.CREDIT,50_000),
            new Transaction("200002",TransactionType.DEBIT,150_000),
            new Transaction("300003",TransactionType.CREDIT,250_000),
            new Transaction("400004",TransactionType.CREDIT,350_000));

    @Test
    public void transactionCounterUpperLimitTest() {
        TransactionCounter transactionCounter = new TransactionCounter();
        assertEquals(1, transactionCounter.transactionCounterUpperLimit(transactions,100_000));
        assertEquals(3, transactionCounter.transactionCounterUpperLimit(transactions,300_000));
    }
}
