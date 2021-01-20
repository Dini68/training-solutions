package timesheet;

import java.io.InputStream;

public class Company {

    private InputStream employeesFile;

    private InputStream projectsFile;

    public Company(InputStream employeesFile, InputStream projectsFile) {
        this.employeesFile = employeesFile;
        this.projectsFile = projectsFile;
    }
}
