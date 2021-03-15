package _toto.ppp;
public class Concatenator {
    public static String convert(int a, int b) {
        return a + Integer.toString(b);
    }
    public static void main(String[] args) {
        System.out.println(convert(5, 10));
        System.out.println(Concatenator.convert(3, 15));
        System.out.println(new Concatenator().convert(4, 7));
    }
}
