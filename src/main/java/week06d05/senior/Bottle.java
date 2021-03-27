package week06d05.senior;

public class Bottle {

    private BottleType type;
    private int filledUntil;

    public Bottle(BottleType type, int filledUntil) {
        this.type = type;
        this.filledUntil = filledUntil;
    }

    public Bottle(BottleType type) {
        this.type = type;
        this.filledUntil = 0;
    }

    public BottleType getType() {
        return type;
    }

    public int getFilledUntil() {
        return filledUntil;
    }
    public static Bottle of(BottleType bottleType) {
        return new Bottle(bottleType);
    }

    public void fill(int fillAmount) {
        if (filledUntil + fillAmount > type.getMaximumAmount()) {
            throw new IllegalArgumentException("too much");
        }
        filledUntil += fillAmount;
    }
}
