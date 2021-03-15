package _aaa;
public class Duck extends Bird {

    public void move() {
        System.out.println("Waddle");
    }

    public static void main(String[] args) {
        Duck d = new Duck();
        d.move();
    }
}