package week10d01.senior;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employees1 = new ArrayList<>();
        Employee employee = new Employee();
        employee.setName("Joe");
        employees1.add(employee);

        List<Employee> employees2 = new ArrayList<>(employees1);
        employees2.get(0).setName("Jack");
        System.out.println(employees1.get(0).getName());
    }
}
