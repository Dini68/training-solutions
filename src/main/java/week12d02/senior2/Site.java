package week12d02.senior2;

public class Site {

    private int side;

    private int width;

    private String color;

    private int number;

    public void isValidSide(int side) {
        if (!(side == 0 || side == 1)) {
            throw new IllegalArgumentException("Side can be 0 or 1: Actual: " + side);
        }
    }

    public void isValidWidth(int width) {
        if (width < 8 || width > 20) {
            throw new IllegalArgumentException("Width can be between 8 and 20. Actual: " + width);
        }
    }

    public void isValidColor(String color) {
        String colorChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#:";
        if (!colorChar.contains(color) || color.length() != 1) {
            throw new IllegalArgumentException("Color can't be this character. Actual: " + color);
        }
    }

    public void isValidParam(int side, int width, String color) {
        isValidSide(side);
        isValidWidth(width);
        isValidColor(color);
    }

    public Site(int side, int width, String color, int number) {
        isValidParam(side, width, color);
        this.side = side;
        this.width = width;
        this.color = color;
        this.number = number;
    }

    public int getSide() {
        return side;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return  "side=" + side +
                ", width=" + width +
                ", color='" + color + '\'' +
                ", number=" + number +
                "\n";
    }
}
