package intromethods;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee = new Employee("Kovács Dénes", 2014, 800_000);

        System.out.println(employee.toString());

        employee.raiseSalary(200_000);

        System.out.println(employee.toString());

        employee.setName("Simon Ferenc");

        System.out.println("Név: " + employee.getName());
        System.out.println("Belépés éve: " + employee.getHiringYear());
        System.out.println("Fizetés: " + employee.getSalary());
    }
}
