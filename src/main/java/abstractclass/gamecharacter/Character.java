package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {

    private Point position;

    private int hitPoint;

    private Random random;

    private boolean isAlive() {
        return (hitPoint > 0);
    }

    public Character(Point position) {
        this.position = position;
        this.hitPoint = 100;
    }

    public Point getPosition() {
        return position;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    protected int getActualPrimaryDamage() {
        return random.nextInt(10) + 1;
    }

    private int getActualDefence() {
        return random.nextInt(6);
    }

    protected void hit(Character enemy, int damage) {
        if (getActualDefence() < damage) {
            decreaseHitPoint(damage);
        }
    }

    public void primaryAttack(Character enemy) {
        hit(enemy, getActualPrimaryDamage());
    }

    private void decreaseHitPoint(int diff) {
        hitPoint -= diff;
    }

    public abstract void secondaryAttack(Character enemy) ;
}
