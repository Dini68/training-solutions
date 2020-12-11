package abstractclass.gamecharacter;

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

    public double distance(long x, long y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y)*(this.y - y));
    }
}
