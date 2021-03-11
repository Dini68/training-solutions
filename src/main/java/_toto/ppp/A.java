package _toto.ppp;

public class A {
    String s = "-";
    protected A() {
        this("d");
        s += "a";
    }
    private A(String e) {
        s += "d";
    }
}
