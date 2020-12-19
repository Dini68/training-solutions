package constructoroverloading.bustimetable;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable;

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        List<SimpleTime> btt = new ArrayList<>();
        for (int hour = firstHour; hour <= lastHour; hour++) {
            btt.add(new SimpleTime(hour, everyMinute));
        }
        this.timeTable = btt;
    }
    public SimpleTime nextBus(SimpleTime actual) {
        for (SimpleTime st: timeTable) {
            if (actual.getHours() * 60 + actual.getMinutes() < st.getHours() * 60 + st.getMinutes()) {
                return  st;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }

}
