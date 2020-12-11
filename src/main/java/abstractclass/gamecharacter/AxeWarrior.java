package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character{

    public AxeWarrior(Point position, Random random) {
        super(position, random);
    }

    private int getActualSecondaryDamage() {
        return new Random().nextInt(10);
    }

    public void secondaryAttack(Character enemy) {

    }
}
