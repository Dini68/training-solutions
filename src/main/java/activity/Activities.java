package activity;

import java.util.List;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity (Activity activity) {
        activities.add(activity);
    }

    public List<Report> distanceByTypes() {
        //
        return null;
    }

    public int numberOfTrackActivities() {
        //
        return 1;
    }

    public int numberOfWithoutTrackActivities() {
        //
        return 1;
    }


}
