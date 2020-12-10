package inheritancemethods.debitcreditaccounts;

public class CreditAccount extends DebitAccount {

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        if (super.transaction(amount)) return true;
        if (amount <= getBalance() - costOfTransaction(amount) + overdraftLimit) {
            overdraftLimit -= amount - getBalance() + costOfTransaction(amount);
            balanceToZero();
            return true;
        }
        return false;
    }
}
