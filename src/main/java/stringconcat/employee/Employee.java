package stringconcat.employee;

public class Employee {

    private String name;

    private String profession;

    private int salary;

    public Employee(String name, String profession, int salary) {
        if (name.equals("") || profession.equals("")) {
            throw new IllegalArgumentException("Nem lehet üres mező!");
        }
        if (salary == 0) {
            throw new IllegalArgumentException("A fizetés nem lehet 0!");
        }
        if (!(salary % 1000 == 0)) {
            throw new IllegalArgumentException("A fizetésnek 1000-rel oszthatónak kell lennie!");
        }
        this.name = name;
        this.profession = profession;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - " +
               profession + " - " +
               salary + " Ft";
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Kovács Dénes", "CDA", 800_000);
        System.out.println(employee.toString());
        employee = new Employee("Kis Elemér", "fodrász", 400_500);
        System.out.println(employee.toString());
    }
}
