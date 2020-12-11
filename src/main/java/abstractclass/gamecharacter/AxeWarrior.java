package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character{

    public AxeWarrior(Point position) {
        super(position);
    }

    private int getActualSecondaryDamage() {
        return new Random().nextInt(10);
    }

    public void secondaryAttack(Character enemy) {

    }
}
