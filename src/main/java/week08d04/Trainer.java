package week08d04;

public class Trainer {

    private CanMark canMark;

    public Trainer(CanMark canMark) {
        this.canMark = canMark;
    }

    public int giveMark() {
        return canMark.giveMark();
    }

    public static void main(String[] args) {
        Trainer trainerGoodMood = new Trainer(new GoodMood());
        Trainer trainerBadMood = new Trainer(new BadMood());
        System.out.println(trainerGoodMood.giveMark());
        System.out.println(trainerBadMood.giveMark());
    }

}
