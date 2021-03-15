package _toto.ppp;
public class Trainer2 {
    private String name;
    private int age;

    public Trainer2() {
        this("lkl");
        String name = "ano";
    }
    public Trainer2(int age) {
        this("Anon", age);
    }
    public Trainer2(String name) {
        this(name, 0);
    }
    public Trainer2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}