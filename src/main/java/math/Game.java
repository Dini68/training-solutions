package math;

import java.util.Random;

public class Game {

    public static void main(String[] args) {

        Random random = new Random();

        Point point1 = new Point(random.nextInt(10), random.nextInt(10));
        Point point2 = new Point(random.nextInt(10), random.nextInt(10));

        Warrior warrior1 = new Warrior("Hulk", point1);
        Warrior warrior2 = new Warrior("Superman", point2);

        System.out.println(warrior1.getName() + ": X=" + warrior1.getPosition().getX()
                                              + ", Y=" + warrior1.getPosition().getY()
                                              + ", Életerő: " + warrior1.getStamina()
                                              + ", Ügyesség: " + warrior1.getSkill());

        System.out.println(warrior2.getName() + ": X=" + warrior2.getPosition().getX()
                                              + ", Y=" + warrior2.getPosition().getY()
                                              + ", Életerő: " + warrior2.getStamina()
                                              + ", Ügyesség:  " + warrior2.getSkill());
    }
}
