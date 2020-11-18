package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {

    private List<String> days = Arrays.asList("Hétfő", "Kedd", "Szerda", "csütörtök",
            "Péntek", "Szombat", "Vasárnap");

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public static void main(String[] args) {
        Week week = new Week();
        System.out.println(week.getDays());
        System.out.println(week.days.get(3));

        String day = week.days.get(2);
        week.days.set(2, week.days.get(1));
        week.days.set(1, day);
        System.out.println(week.getDays());

    }
}
