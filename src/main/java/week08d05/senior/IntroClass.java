package week08d05.senior;

public interface IntroClass {

    default int multiply(int a, int b) {
        writeAB(a, b);
        return a * b;
    }

    private void writeAB (int a, int b) {
        System.out.print(a + " * " + b + " = ");
    }

    static void go() {
        System.out.println("go");
    }
}
