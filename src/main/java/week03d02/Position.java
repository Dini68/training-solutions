package week03d02;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private String name;

    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", bonus=" + bonus +
                '}';
    }

    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position("sales", 100_000));
        positions.add(new Position("picker", 130_000));
        positions.add(new Position("trainer", 200_000));
        positions.add(new Position("delivery", 160_000));
        positions.add(new Position("boss", 500_000));

        for (Position position: positions) {
            if (position.getBonus() > 150_000) {
                System.out.println(position);
            }
        }
    }
}
