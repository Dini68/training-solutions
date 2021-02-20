package timesheet;

public class Employee {

    private final String firstName;

    private final String lastName;

    public Employee(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException(
                    "First name cannot be empty or null, actual: '" + firstName + "'");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException(
                    "Last name cannot be empty or null, actual: '" + lastName + "'");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
