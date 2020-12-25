package math.game;

import java.util.Random;

public class Warrior {

    private String name;

    private int stamina;

    private double skill;

    private Point position;

    public int getStamina() {
        return stamina;
    }

    public double getSkill() {
        return skill;
    }

    public Warrior(String name, Point point) {
        this.name = name;
        this.position = point;
        this.stamina = new Random().nextInt(81) + 20;
        this.skill = new Random().nextDouble();
    }

    public Point getPosition() {
        return position;
    }

    public void move(Warrior warrior) {
        if (position.getX() < warrior.position.getX()) {
            position.setX(position.getX() + 1);
        }
        if (position.getX() > warrior.position.getX()) {
            position.setX(position.getX() - 1);
        }
        if (position.getY() < warrior.position.getY()) {
            position.setY(position.getY() + 1);
        }
        if (position.getY() > warrior.position.getY()) {
            position.setY(position.getY() - 1);
        }
    }

    public double distance(Warrior warrior) {
        return position.distance(warrior.position);
    }

    public void attack(Warrior warrior) {
        if (new Random().nextDouble() < skill) {
            warrior.stamina -= new Random().nextInt(3) + 1;
        }
    }

    public boolean isAlive() {
        return stamina > 0;
    }

    @Override
    public String toString() {
        return name + ": (" + position.getX() + ", " + position.getY() + ") " + stamina;
    }
}
