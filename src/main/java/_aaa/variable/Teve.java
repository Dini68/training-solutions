package _aaa.variable;

import java.util.ArrayList;
import java.util.List;

public class Teve {

    public void throwException() {
        System.out.print("throwex ");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            System.out.print("try ");
            new Teve().throwException();
        } catch (Exception re) {
            System.out.print("catch ");
        } finally {
            System.out.print("finally ");
        }
        System.out.println("done ");
    }
}