package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character {

    private int numberOfArrows;

    public int getNumberOfArrows() {
        return numberOfArrows;
    }

    public Archer(Point position) {
        super(position);
        this.numberOfArrows = 100;
    }

    private int getActualSecondaryDamage() {
        return new Random().nextInt(5) + 1;
    }

    private void shootingAnArrow(Character enemy) {
        numberOfArrows --;
        hit(enemy, getActualSecondaryDamage());
    }

    public void secondaryAttack(Character enemy) {
        shootingAnArrow(enemy);
    }
}
