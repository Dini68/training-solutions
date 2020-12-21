package interfaceextends;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot{

    private Point position;

    private int angle;

    private List<Point> path = new ArrayList<>();

    public final static long ALTITUDE = 5;

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }


    public AstroBoy(Point position) {
        this.position = position;
    }

    public void walkTo(Point position) {
        this.position = position;
        path.add(position);
    }
    public void flyTo(Point position) {
        this.position = position;
        path.add(position);
    }
    @Override
    public void liftTo(long altitude) {
        position = new Point(position.getX(), position.getY(), altitude);
        path.add(position);
    }

    @Override
    public void moveTo(Point position) {
        this.position = position;
        path.add(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        this.position = new Point(this.position.getX(), this.position.getY(), ALTITUDE);
        path.add(this.position);
        this.position = new Point(position.getX(), position.getY(), ALTITUDE);
        path.add(this.position);
        this.position = new Point(position.getX(), position.getY(), 0);
        path.add(this.position);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }

    public long getAltitude() {
        return this.position.getZ();
    }

    public static void main(String[] args) {
        Point initialPoint = new Point(0, 0, 0);
        AstroBoy astroBoy = new AstroBoy(initialPoint);
        Point targetPoint = new Point(12L, 23L, 0);
        //When
        astroBoy.fastMoveTo(targetPoint);
        //Then

        System.out.println(astroBoy.getPath().size());
    }
}
