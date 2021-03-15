package _toto.ppp;

public class Program {

    public static void main(String[] args) {
        System.out.println(new Inch(new Meter(1)));
        System.out.println(new Inch(new Foot(1).toMeter()));
    }
}
