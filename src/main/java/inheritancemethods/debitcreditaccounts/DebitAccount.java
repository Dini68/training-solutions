package inheritancemethods.debitcreditaccounts;

public class DebitAccount {

    private String accountNumber;

    private long balance;

    private final static double COST = -3.0;

    private final static long MIN_COST = -200;

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final long costOfTransaction(long amount) {

        return (long)Math.max(-amount * COST / 100, -MIN_COST);
    }

    public boolean transaction(long amount) {
        if (amount <= balance - costOfTransaction(amount)) {
            balance -= amount + costOfTransaction(amount);
            return true;
        }
        return false;
    }

    public void balanceToZero() {
        balance = 0;
    }
}
