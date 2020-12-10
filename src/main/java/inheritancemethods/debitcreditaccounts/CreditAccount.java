package inheritancemethods.debitcreditaccounts;

public class CreditAccount extends DebitAccount {

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
}
