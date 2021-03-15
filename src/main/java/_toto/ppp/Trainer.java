package _toto.ppp;

public class Trainer {
    private String name;

    public Trainer() {
    }

    public String getName() {
        return name;
    }

    public Trainer(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Trainer trainer = new Trainer("Anonymous");
        Trainer trainer2 = new Trainer(null);
        Trainer trainer3 = new Trainer();
        System.out.println(trainer.getName());
        System.out.println(trainer2.getName());
        System.out.println(trainer3.getName());

    }
}