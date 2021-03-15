package _aaa.variable;

import java.util.Comparator;

public class Student{

    private String name;

    private int balance;

    public Student(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "\n" + name + " " + balance;
    }

}
