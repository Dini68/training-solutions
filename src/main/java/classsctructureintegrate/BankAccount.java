package classsctructureintegrate;

public class BankAccount {

    private String accountNumber;

    private String owner;

    private int balance;

    public BankAccount (String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public int deposit ( int amount) {
        return this.balance += amount;
    }

    public int withdraw ( int amount) {
        return this.balance -= amount;
    }

    public String getInfo() {
        return this.owner + " (" + this.accountNumber + "): " + this.balance + " Ft";
    }

//    public int transfer( String accountNumber, int amount) {
//        return
//    }
}
