package classsctructureintegrate;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("1. owner: ");
        String owner = scanner.nextLine();
        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Balance: ");
        int balance = scanner.nextInt();
        scanner.nextLine();

        BankAccount bankAccount1 = new BankAccount(accountNumber, owner, balance);

        System.out.println(bankAccount1.getInfo());

        System.out.print("2. owner: ");
        String owner2 = scanner.nextLine();
        System.out.print("Account Number: ");
        String accountNumber2 = scanner.nextLine();
        System.out.print("Balance: ");
        int balance2 = scanner.nextInt();
        scanner.nextLine();

        BankAccount bankAccount2 = new BankAccount(accountNumber2, owner2, balance2);

        System.out.println(bankAccount2.getInfo());

        System.out.print("1. deposit: ");
        bankAccount1.deposit(scanner.nextInt());

        System.out.println(bankAccount1.getInfo());

        System.out.print("2. deposit: ");
        bankAccount2.deposit(scanner.nextInt());

        System.out.println(bankAccount2.getInfo());

        System.out.print("1. withdraw: ");
        bankAccount1.withdraw(scanner.nextInt());

        System.out.println(bankAccount1.getInfo());

        System.out.print("2. withdraw: ");
        bankAccount2.withdraw(scanner.nextInt());

        System.out.println(bankAccount2.getInfo());
    }
}
