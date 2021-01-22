package timesheet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employees = new ArrayList<>();

    private List<Project> projects = new ArrayList<>();

    private List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    private StringBuilder sb = new StringBuilder();

    private void addEmployee(int size, byte[] buffer) {
        for (int i = 0; i < size; i++) {
            char c = (char) (buffer[i]);
            if (c != '\n' && c != '\r') sb.append(c);
            if (c == '\n') {
                String firstName = sb.toString().split(" ")[0];
                String lastName = sb.toString().split(" ")[1];
                employees.add(new Employee(firstName, lastName));
                sb = new StringBuilder();
            }
        }
    }

    private void addEmployeesFromFile(InputStream employeesFile) {
        sb = new StringBuilder();
        InputStream is = employeesFile;
        byte[] buffer = new byte[1000];
        int size;
        try {
            while ((size = is.read(buffer)) > 0) {
                addEmployee(size, buffer);
            }
            if (sb.length() > 0) {
                String firstName = sb.toString().split(" ")[0];
                String lastName = sb.toString().split(" ")[1];
                employees.add(new Employee(firstName, lastName));
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("can not read file");
        }
    }

    private void addProject(int size, byte[] buffer) {
        for (int i = 0; i < size; i++) {
            char c = (char) (buffer[i]);
            if (c != '\n' && c != '\r') sb.append(c);
            if (c == '\n') {
                projects.add(new Project(sb.toString()));
                sb = new StringBuilder();
            }
        }
    }

    private void addProjectsFromFile(InputStream projectsFile) {
        sb = new StringBuilder();
        InputStream is = projectsFile;
        byte[] buffer = new byte[10];
        int size;
        try {
            while ((size = is.read(buffer)) > 0) {
                addProject(size, buffer);
            }
            if (sb.length() > 0) {
                projects.add(new Project(sb.toString()));
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("can not read file");
        }
    }

    public Company(InputStream employeesFile, InputStream projectsFile) {
        addEmployeesFromFile(employeesFile);
        addProjectsFromFile(projectsFile);
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endTime) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endTime));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        return new ArrayList<>();
    }

    public void printToFile(String employeeName, int year, int month, Path file) {
        String result = employeeName + "\t" + year + "-" + month + "\t" +
        "John Connor\t2013-01\t14\n" +
                "Java\t10\n" +
                "C++\t4\n";
//        Files.writeString(file, )
//        System.out.println();
    }

    public static void main(String[] args) {
        Company company = new Company(
                Company.class.getResourceAsStream("/employees.txt"),
                Company.class.getResourceAsStream("/projects.txt"));


        System.out.println(company.getEmployees().get(0).getName());
        System.out.println(company.getEmployees().get(3).getName());
        }



}
