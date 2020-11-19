package math;

import java.util.Random;

public class Warrior {

    private final Random random = new Random();

    private String name;
    private Point position;
    private int stamina;
    private double skill;

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        stamina = random.nextInt(81) +20;
        skill = ((int)((random.nextDouble() + 0.0005) * 1000)) / 1000.0;
    }

    public Point getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }

    public double getSkill() {
        return skill;
    }

    public void move(Warrior warrior) {


    }

    public void attack(Warrior warrior) {

    }

    public double distance(Warrior warrior) {
        return 1;
    }

    public boolean isAlive() {
        return false;
    }

    public String toString() {
        return " ";
    }
}
