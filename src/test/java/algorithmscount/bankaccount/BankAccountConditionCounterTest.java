package algorithmscount.bankaccount;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BankAccountConditionCounterTest {

    List<BankAccount> bankAccounts = Arrays.asList(
            new BankAccount("Kovács Dénes","01010101",100_000),
            new BankAccount("Simon Ferenc","02020202",50_000),
            new BankAccount("Nagy Ervin","03030303",70_000),
            new BankAccount("Kiss György","04040404",120_000));

    @Test
    public void bankAccountConditionCounterTest() {
        BankAccountConditionCounter bankAccountConditionCounter = new BankAccountConditionCounter();
        assertEquals(3, bankAccountConditionCounter.bankAccountConditionCounter(bankAccounts,60_000));
    }
}
