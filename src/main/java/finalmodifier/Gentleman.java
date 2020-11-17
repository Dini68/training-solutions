package finalmodifier;

public class Gentleman {

    private static final String MESSAGE_PREFIX = "Hello ";

    public String getMessagePrefix(String name) {
        return MESSAGE_PREFIX + name;
    }

    public static void main(String[] args) {

        Gentleman gentleman = new Gentleman();

        System.out.println(gentleman.getMessagePrefix("Dénes"));
    }
}