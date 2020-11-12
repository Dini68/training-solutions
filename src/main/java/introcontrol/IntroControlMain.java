package introcontrol;

public class IntroControlMain {

    public static void main(String[] args) {

        IntroControl introControl = new IntroControl();

        System.out.println("8:" + introControl.substractTenIfGreaterThanTen(8));
        System.out.println("58: " + introControl.substractTenIfGreaterThanTen(58));
        System.out.println("888: " + introControl.substractTenIfGreaterThanTen(888));

        System.out.println("0: " + introControl.describeNumber(0));
        System.out.println("10: " + introControl.describeNumber(10));
        System.out.println("1000: " + introControl.describeNumber(1000));

        System.out.println("Jack: " + introControl.greetingToJoe("Jack"));
        System.out.println("Joe: " + introControl.greetingToJoe("Joe"));
        System.out.println("Joel: " + introControl.greetingToJoe("Joel"));

        System.out.println("2.000.000Ft-nál jutalék: " +
                introControl.calculateBonus(2_000_000) + "Ft");
        System.out.println("1.000.000Ft-nál jutalék: " +
                introControl.calculateBonus(1_000_000) + "Ft");
        System.out.println("999.000Ft-nál jutalék: " +
                introControl.calculateBonus(999_000) + "Ft");


    }
}
