package debug.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Munkavállaló neve: ");
        String name = scanner.nextLine();

        System.out.print("Munkavállaló születési éve: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Employee employee1 = new Employee(name, year);

        System.out.print("Munkavállaló neve: ");
        name = scanner.nextLine();

        System.out.print("Munkavállaló születési éve: ");
        year = scanner.nextInt();
        scanner.nextLine();

        Employee employee2 = new Employee(name, year);

        System.out.print("Munkavállaló neve: ");
        name = scanner.nextLine();

        System.out.print("Munkavállaló születési éve: ");
        year = scanner.nextInt();
        scanner.nextLine();

        Employee employee3 = new Employee(name, year);

        Company company = new Company(new ArrayList<>());

        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);

        System.out.println(company.listEmployeeNames());

        Employee employee = ((company.findEmployeeByName("Hunor")));
        System.out.println(employee.getName() + " " + employee.getYearOfBirth());
    }
}
