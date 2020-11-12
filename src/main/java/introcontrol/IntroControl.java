package introcontrol;

public class IntroControl {

    public int substractTenIfGreaterThanTen(int number) {
        if (number > 10) {
            return number - 10;
        } else {
            return number;
        }
    }

    public String describeNumber(int number) {
        if (number == 0) {
            return "zero";
        }
        else {
            return "not zero";
        }
    }

    public String greetingToJoe(String name) {
        if (name.equals("Joe")) {
            return "Hello Joe";
        }
        else {
            return "";
        }

    }
}
