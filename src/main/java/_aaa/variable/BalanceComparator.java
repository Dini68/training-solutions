package _aaa.variable;

import java.util.Comparator;

public class BalanceComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getBalance() - o2.getBalance();
    }
}
