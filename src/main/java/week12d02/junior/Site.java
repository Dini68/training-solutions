package week12d02.junior;

import week12d02.junior.Fence;

public class Site {

    private int side;
    private int length;
    private Fence fence;

    public Site(int side, int length, Fence fence) {
        this.side = side;
        this.length = length;
        this.fence = fence;
    }

    public int getSide() {
        return side;
    }

    public int getLength() {
        return length;
    }

    public Fence getFence() {
        return fence;
    }

    @Override
    public String toString() {
        return "Site{" +
                "s=" + side +
                ", l=" + length +
                "m, f=" + fence +
                '}';
    }
}