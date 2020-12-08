package introinheritance.personemployeeboss;

public class BigBoss extends Boss {

    private double bonus;

    public BigBoss(String name, String address, double salary, int numberOfEmployees, double bonus) {
        super(name, address, salary, numberOfEmployees);
        this.bonus = bonus;
    }

    @Override
    public int getNumberOfEmployees() {
        return super.getNumberOfEmployees();
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + getBonus();
    }

    public static void main(String[] args) {
        BigBoss boss = new BigBoss("John Doe", "1117 Budapest, Budafoki út 56.", 1_000_000, 6, 200_000);
        System.out.println(boss.getSalary());
    }
}
