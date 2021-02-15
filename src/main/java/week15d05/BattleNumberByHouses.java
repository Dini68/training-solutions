package week15d05;

public class BattleNumberByHouses implements Comparable<BattleNumberByHouses> {

    private String name;

    private int number;

    public BattleNumberByHouses(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "battleNumberByHouses{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public int compareTo(BattleNumberByHouses o) {
        return this. number - o.number;
    }
}
