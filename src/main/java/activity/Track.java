package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate () {
        return new Coordinate(1,1);
    }

    public Coordinate findMinimumCoordinate () {
        return new Coordinate(1,1);
    }

    public double getDistance() {
        double distance = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            distance += trackPoints.get(i-1).getDistanceFrom(trackPoints.get(i));
        }
        return distance;
    }

    public double getFullDecrease() {
        return 1;
    }

    public double getFullElevation() {
        return 1;
    }

    public double GetRectangleArea() {
        return 1;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void loadFromGpx() {

    }
}
