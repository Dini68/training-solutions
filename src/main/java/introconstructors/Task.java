package introconstructors;

import statements.Time;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Task {

    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private LocalTime duration;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void start() {
        startDateTime = LocalDateTime.now();
    }

    public static void main(String[] args) {

        Task task = new Task("Gumicsere", "A nyári gumik lecserélése téli gumikra");

        task.start();

        System.out.println(task.getStartDateTime());

        LocalTime localTime = LocalTime.of(1,30);
        task.setDuration(localTime);

        System.out.println(task.title);
        System.out.println(task.description);
        System.out.println(task.getStartDateTime());
        System.out.println(task.getDuration());
     }
}
