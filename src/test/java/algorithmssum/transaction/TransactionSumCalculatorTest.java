package algorithmssum.transaction;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransactionSumCalculatorTest {

    List<Transaction> transactions = Arrays.asList(
                new Transaction("10001210",TransactionOperation.CREDIT,100_000),
                new Transaction("10001210",TransactionOperation.DEBIT,200_000),
                new Transaction("10001210",TransactionOperation.CREDIT,300_000),
                new Transaction("10001210",TransactionOperation.DEBIT,100_000),
                new Transaction("10001210",TransactionOperation.CREDIT,100_000));
    @Test
    public void sumAmountOfCreditEntriesTest() {
        assertEquals(200000, new TransactionSumCalculator().sumAmountOfCreditEntries(transactions));
    }
}
