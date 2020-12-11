package abstractclass.gamecharacter;

import java.util.Random;

public class Point {

    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public double distance(Point otherPoint) {
        return Math.round(Math.sqrt((this.x - otherPoint.x) * (this.x - otherPoint.x)
                + (this.y - otherPoint.y)*(this.y - otherPoint.y)));
    }

}
