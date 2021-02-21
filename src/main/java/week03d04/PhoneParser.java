package week03d04;

public class PhoneParser {

    public Phone parse(String text) {
        String prefix = text.split("-")[0];
        String number = text.split("-")[1];
        return new Phone(prefix, number);
    }

    public static void main(String[] args) {
        Phone phone = new PhoneParser().parse("30-2260657");
        System.out.println(phone);
    }
}
