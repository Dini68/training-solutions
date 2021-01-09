package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate () {
        double maxLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        for (int i = 1; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getCoordinate().getLatitude() > maxLatitude) {
                maxLatitude = trackPoints.get(i).getCoordinate().getLatitude();
            }
            if (trackPoints.get(i).getCoordinate().getLongitude() > maxLongitude) {
                maxLongitude = trackPoints.get(i).getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLatitude, maxLongitude);
    }

    public Coordinate findMinimumCoordinate () {
        double minLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double minLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        for (int i = 1; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getCoordinate().getLatitude() < minLatitude) {
                minLatitude = trackPoints.get(i).getCoordinate().getLatitude();
            }
            if (trackPoints.get(i).getCoordinate().getLongitude() < minLongitude) {
                minLongitude = trackPoints.get(i).getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLatitude, minLongitude);
    }

    public double getDistance() {
        double distance = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            distance += trackPoints.get(i-1).getDistanceFrom(trackPoints.get(i));
        }
        return distance;
    }

    public double getFullDecrease() {
        double fullDecrease = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            if(trackPoints.get(i).getElevation() < trackPoints.get(i-1).getElevation()) {
                fullDecrease += trackPoints.get(i - 1).getElevation() - trackPoints.get(i).getElevation();
            }
        }
        return fullDecrease;
    }

    public double getFullElevation() {
        double fullElevation = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            if(trackPoints.get(i).getElevation() > trackPoints.get(i-1).getElevation()) {
                fullElevation += trackPoints.get(i).getElevation() - trackPoints.get(i - 1).getElevation();
            }
        }
        return fullElevation;
    }

    public double getRectangleArea() {
        double maxLatitudeDifference = this.findMaximumCoordinate().getLatitude() -
                                       this.findMinimumCoordinate().getLatitude();
        double maxLongitudeDifference = this.findMaximumCoordinate().getLongitude() -
                                        this.findMinimumCoordinate().getLongitude();
        return maxLatitudeDifference * maxLongitudeDifference;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void loadFromGpx() {

    }
}
