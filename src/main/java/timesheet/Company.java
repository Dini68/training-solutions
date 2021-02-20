package timesheet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Company {

    private final List<Employee> employees = new ArrayList<>();

    private final List<Project> projects = new ArrayList<>();

    private final List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    public List<TimeSheetItem> getTimeSheetItems() {
        return new ArrayList<>(timeSheetItems);
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }


    private void addEmployeesFromFile(InputStream employeesFile) {
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[1000];
        int size;
        try {
            while ((size = employeesFile.read(buffer)) > 0) {
                for (int i = 0; i < size; i++) {
                    char c = (char) (buffer[i]);
                    if (c != '\n' && c != '\r') sb.append(c);
                    if (c == '\n') {
                        sb = addEmployee(sb);
                    }
                }
            }
            if (sb.length() > 0) {
                sb = addEmployee(sb);
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("can not read file");
        }
    }

    private StringBuilder addEmployee(StringBuilder sb) {
        String firstName = sb.toString().split(" ")[0];
        String lastName = sb.toString().split(" ")[1];
        employees.add(new Employee(firstName, lastName));
        sb = new StringBuilder();
        return sb;
    }

    private void addProjectsFromFile(InputStream projectsFile) {
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[10];
        int size;
        try {
            while ((size = projectsFile.read(buffer)) > 0) {
                for (int i = 0; i < size; i++) {
                    char c = (char) (buffer[i]);
                    if (c != '\n' && c != '\r') sb.append(c);
                    if (c == '\n') {
                        projects.add(new Project(sb.toString()));
                        sb = new StringBuilder();
                    }
                }
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
        validNameControl(employeeName);

        List<ReportLine> result = new ArrayList<>();
        for (Project p: getProjects()) {
            result.add(new ReportLine(p, 0));
        }
        for (TimeSheetItem ts: getTimeSheetItems()) {
            if (ts.getEmployee().getName().equals(employeeName) &&
                ts.getBeginDate().getYear() == year &&
                ts.getBeginDate().getMonthValue() == month) {
                for ( ReportLine rl: result) {
                    if (rl.getProject().getName().equals(ts.getProject().getName())) {
                        rl.addTime(ts.hoursBetweenDates());
                    }
                }
            }
        }
        return result;
    }

    private void validNameControl(String employeeName) {
        boolean isFoundName = false;
        for (Employee e: getEmployees()) {
            if (e.getName().equals(employeeName)) {
                isFoundName = true;
            }
        }
        if (!isFoundName) {
            throw new IllegalArgumentException("No such name among employees");
        }
    }

    public void printToFile(String employeeName, int year, int month, Path file) {
        List<ReportLine> reports;
        validNameControl(employeeName);
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int sumHour = 0;
        reports = calculateProjectByNameYearMonth(employeeName, year, month);
        for (ReportLine rl: reports) {
            sumHour +=rl.getTime();
            if (rl.getTime() > 0) {
                temp.append(rl.getProject().getName()).append("\t").append(rl.getTime()).append("\n");
            }
        }

        if (month < 10) {
            result.append(employeeName).append("\t").append(year).append("-0")
                  .append(month).append("\t").append(sumHour).append("\n").append(temp);
        }
        else {
            result.append(employeeName).append("\t").append(year).append("-")
                  .append(month).append("\t").append(sumHour).append("\n").append(temp);
        }
        try {
            Files.writeString(file, result.toString());
        } catch (IOException e) {
            throw new IllegalStateException("can not read", e);
        }
    }

    public static void main(String[] args) {
        Company company = new Company(
                Company.class.getResourceAsStream("/employees.txt"),
                Company.class.getResourceAsStream("/projects.txt"));

        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("Java"),
                LocalDateTime.of(2013, Month.JANUARY, 27, 8, 0, 0),
                LocalDateTime.of(2013, Month.JANUARY, 27, 16, 10, 0)
        );


        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("Java"),
                LocalDateTime.of(2013, Month.JANUARY, 26, 8, 0, 0),
                LocalDateTime.of(2013, Month.JANUARY, 26, 10, 10, 0)
        );


        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("C++"),
                LocalDateTime.of(2013, Month.JANUARY, 25, 8, 0, 0),
                LocalDateTime.of(2013, Month.JANUARY, 25, 12, 10, 0)
        );
        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("C++"),
                LocalDateTime.of(2013, Month.FEBRUARY, 25, 8, 0, 0),
                LocalDateTime.of(2013, Month.FEBRUARY, 25, 12, 10, 0)
        );
        System.out.println(company.calculateProjectByNameYearMonth("John Connor", 2013, 1).get(0).getTime());
        System.out.println(company.calculateProjectByNameYearMonth("John Connor", 2013, 1).get(1).getTime());
        System.out.println(company.calculateProjectByNameYearMonth("John Connor", 2013, 1).get(3).getTime());

    }
}
