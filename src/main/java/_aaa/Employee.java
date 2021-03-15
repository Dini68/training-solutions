package _aaa;

public class Employee extends Person {

    private String name;

    private int salary;

    private Employee () {
        super();
    }

    public void sg () {
        System.out.println("Employee");

    }

    public static void main(String[] args) {
        Employee ep = new Employee();
        ep.sg();

    }

}
