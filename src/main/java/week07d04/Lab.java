package week07d04;

import java.time.LocalDate;

public class Lab {

    private String title;

    private boolean completed;

    private LocalDate completedAt;

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getCompletedAt() {
        return completedAt;
    }

    public Lab(String title) {
        this.title = title;
        completed = false;
    }

    public Lab(String title, LocalDate completedAt) {
        this.title = title;
        this.completedAt = completedAt;
        completed = true;
    }

    public void complete(LocalDate nowReady) {
        this.completedAt = nowReady;
        completed = true;
    }
    public void complete() {
        complete(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Lab{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                ", completedAt=" + completedAt +
                '}';
    }

    public static void main(String[] args) {
        Lab lab = new Lab("programozás");
        System.out.println(lab.toString());
        lab.complete(LocalDate.now());
        System.out.println(lab.toString());
    }
}
