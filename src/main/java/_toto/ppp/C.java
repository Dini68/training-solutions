package _toto.ppp;

class C extends B {
    C() {
        super();
        s += "c";
    }
    public static void main(String... boo) {
        System.out.println((new C()).s);
    }
}
