package math.game;

import java.util.Random;

public class Game {

    public static void main(String[] args) {
        Random rnd = new Random();
        Point point1 = new Point(rnd.nextInt(21), rnd.nextInt(21));
        Warrior batman = new Warrior("Batman", point1);
        Point point2 = new Point(rnd.nextInt(21), rnd.nextInt(21));
        Warrior rambo = new Warrior("Rambo", point2);
        System.out.println("Alaphelyzet");
        System.out.println(batman.toString() + batman.getSkill());
        System.out.println(rambo.toString() + rambo.getSkill());

        int round = 0;
        while (batman.isAlive() && rambo.isAlive()) {
            round ++;
            System.out.println(round + ". round");
            if (batman.distance(rambo) > 0) {
                batman.move(rambo);
            }
            if (rambo.distance(batman) > 0) {
                rambo.move(batman);
            }
            if (batman.distance(rambo) < 0.1) {
                if (batman.isAlive()) {
                    batman.attack(rambo);
                }
                if (rambo.isAlive()) {
                    rambo.attack(batman);
                }
            }
            System.out.println(batman.toString());
            System.out.println(rambo.toString());
        }
        if (batman.isAlive()) {
            System.out.println("Winner: " + batman.toString());
        }
        if (rambo.isAlive()) {
            System.out.println("Winner: " + rambo.toString());
        }

    }
}
