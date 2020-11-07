package localvariables;

public class LocalVariablesMain {

    public static void main(String[] args) {

        Boolean b;

        b = false;

        System.out.println(b);

        int a = 22;

        System.out.println(a);

        int i = 3, j = 4;

        System.out.println(i + " " + j);
        System.out.println(i + j);

        int k = i;

        System.out.println(k);

        String s = "Hello World";

        String t = s;

        System.out.println(t);

        {
            int x = 0;

            System.out.println(a);
        }

    }
}
