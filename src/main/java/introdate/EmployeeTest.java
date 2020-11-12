package introdate;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Birth of year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Birth of month: ");
        int month = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Birth of day: ");
        int day = scanner.nextInt();
        scanner.nextLine();

        Employee employee = new Employee(year, month, day, name);

        System.out.println("Data of employee:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Date of birth: " + employee.getDateOfBirth());
        System.out.println("Begin employment " + employee.getBeginEmployment());

        System.out.print("New name: ");
        String newName = scanner.nextLine();
        employee.setName(newName);

        System.out.println("Data of employee:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Date of birth: " + employee.getDateOfBirth());
        System.out.println("Begin employment " + employee.getBeginEmployment());
    }
}
