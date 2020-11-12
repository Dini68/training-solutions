package introcontrol;

public class IntroControl {

    public int substractTenIfGreaterThanTen(int number) {
        int renumber = number - 10;
        renumber = (number <= 10) ? number : renumber;
        return renumber;
    }
}
