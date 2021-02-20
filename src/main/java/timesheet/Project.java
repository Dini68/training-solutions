package timesheet;

public class Project {

    private final String name;

    public Project(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Project name cannot be empty or null, actual: '" + name + "'");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
