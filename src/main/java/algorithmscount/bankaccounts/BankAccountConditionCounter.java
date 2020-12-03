package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {

    public int bankAccountConditionCounter (List<BankAccount> bankAccounts, int lowerLimit) {
        int count = 0;
        for (BankAccount ba: bankAccounts) {
            if (ba.getBalance() > lowerLimit) {
                count ++;
            }
        }
        return count;
    }
}
