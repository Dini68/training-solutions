package stringtype;

public class StringTypeMain {

    public static void main(String[] args) {

        String prefix = "Hello ";

        String name = "John Doe";

        String message = prefix + name;

        System.out.println(message);

        message = message + 444;

        Boolean b = message.equals("Hello John Doe");
        Boolean c = message.equals("Hello John Doe444");

        System.out.println("message változó értéke: \"Hello John Doe\": " + b);
        System.out.println("message változó értéke: \"Hello John Doe444\": " + c);

        String ures = "";
        ures = ures + ures;

        System.out.println("2 üres sztring hossza konkatenálva: " + ures.length());

        String abc = "Abcde";
        System.out.println(abc + " String hossza: " + abc.length());

        System.out.println(abc + " 1. és 3. karaktere vesszővel elválasztva: " + abc.substring(0, 1) + ", " + abc.substring(2, 3));

        System.out.println(abc + " 1-től a 3. karakterig: " + abc.substring(0,3));

    }

}
