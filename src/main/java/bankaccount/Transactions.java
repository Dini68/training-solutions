package bankaccount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Transactions {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public void readBankAccountFromFile() {
        List<String> acc = new ArrayList<>();
        if (Files.isRegularFile(Path.of("accounts.txt"))) {
            try {
                acc = Files.readAllLines(Path.of("accounts.txt"));
            } catch (IOException e) {
                throw new IllegalStateException("Can not read file", e);
            }
            String name;
            String account;
            int value;
            for (String str: acc) {
                name = str.substring(0, str.indexOf(":"));
                account = str.substring(str.indexOf(":") + 2, str.indexOf(":") + 28);
                value = Integer.parseInt(str.substring(str.indexOf(":") + 29, str.length()));
                bankAccounts.add(new BankAccount(name, account, value));
            }
            for (BankAccount ba: bankAccounts) {
                System.out.println(ba.getName() + " " + ba.getAccount() +
                        " " + ba.getValue());
            }
        }
    }

    public void transactions() {
        List<String> tra = new ArrayList<>();
        if (Files.isRegularFile(Path.of("transactions.txt"))) {
            try {
                tra = Files.readAllLines(Path.of("transactions.txt"));
            } catch (IOException e) {
                throw new IllegalStateException("Can not read file", e);
            }
            String account;
            int value;
            for (String str: tra) {
                account = str.substring(0, 26);
                value = Integer.parseInt(str.substring(27, str.length()));
                for (BankAccount ba: bankAccounts) {
                    if (ba.getAccount().equals(account)) {
                        ba.setValue(ba.getValue() + value);
                    }
                }
            }
            for (BankAccount ba: bankAccounts) {
                System.out.println(ba.getName() + " " + ba.getAccount() +
                        " " + ba.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Transactions transactions = new Transactions();
        transactions.readBankAccountFromFile();
        transactions.transactions();
    }
}
