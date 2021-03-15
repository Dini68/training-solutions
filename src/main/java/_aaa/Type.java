package _aaa;

public enum Type {
    LUXURY(3.0, "Luxury"), FIRST(1.8, "First"), SECOND(1.0, "Second");

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public double multiplier;

    private final String name;

    Type(double multiplier, String name) {
        this.multiplier = multiplier;
        this.name = name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "multiplier=" + multiplier +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(LUXURY.toString());
        System.out.println(SECOND.multiplier * 5);
        System.out.println(FIRST.multiplier * 5);
        System.out.println(FIRST.getName());
        LUXURY.setMultiplier(10);
        System.out.println(LUXURY.getMultiplier() * 2);
    }
}
