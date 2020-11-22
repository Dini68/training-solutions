package typeconversion.whichtype;

public class WhichTypeMain {

    public static void main(String[] args) {

        WhichType whichType = new WhichType();
        System.out.println(whichType.whichType(Long.toString((long)Integer.MAX_VALUE)));
        System.out.println(whichType.whichType(Long.toString((long)Integer.MAX_VALUE + 1)));
        System.out.println(whichType.whichType(Long.toString(2321)));
        System.out.println(whichType.whichType(Long.toString(21)));
    }
}
