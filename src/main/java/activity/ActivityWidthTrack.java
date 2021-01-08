package activity;

public class ActivityWidthTrack implements Activity{

    private Track track;

    private ActivityType activityType;

    public ActivityWidthTrack(Track track, ActivityType activityType) {
        this.track = track;
        this.activityType = activityType;
    }

    @Override
    public double getDistance() {
        return 0;
    }

    @Override
    public ActivityType getType() {
        return null;
    }
}
