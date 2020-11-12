package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {

    private String name;

    private LocalDate dateOfBirth;

    private LocalDateTime beginEmployment;

    public Employee(int year, int month, int day, String name) {
        this.name = name;
        this.dateOfBirth = LocalDate.of(year, month, day);
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.of(time.getYear(), time.getMonth(),
                time.getDayOfMonth(), time.getHour(), time.getMinute());
        this.beginEmployment = time2;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getBeginEmployment() {
        return beginEmployment;
    }

    public void setName(String name) {
        this.name = name;
    }
}
