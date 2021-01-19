package week12d02.senior;

public class Site {

    private String side;

    private String width;

    private String color;

    private String number;

    private String sold;

    public Site(String side, String width, String color, String number) {
        this.side = side;
        this.width = width;
        this.color = color;
        this.number = number;
        this.sold = "N";
    }

    public String getSide() {
        return side;
    }

    public String getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return side + ',' +
               width + ',' +
               color + ',' +
               number + ',' +
               sold;
    }
}
