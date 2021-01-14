package bankaccount;

public class BankAccount {

    private String name;

    private String account;

    private int value;

    public BankAccount(String name, String account, int value) {
        this.name = name;
        this.account = account;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
