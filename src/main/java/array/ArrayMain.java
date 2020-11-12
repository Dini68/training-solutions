package array;

public class ArrayMain {

    public static void main(String[] args) {

        String[] dayOfWeek = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek",
                "Szombat", "Vasárnap"};

        System.out.println(dayOfWeek[1]);
        System.out.println(dayOfWeek.length);

        int[] exponent = new int[5];
        for (int i = 0; i < 5; i++) {
            exponent[i] = 1;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                exponent[i] = exponent[i] * 2;
            }
            System.out.println(i+ ". " + exponent[i]);
        }

        boolean[] b = new boolean[6];
        b[0] = false;
        b[1] = true;
        b[2] = false;
        b[3] = true;
        b[4] = false;
        b[5] = true;

        for (int i = 1; i < 6; i++) {
            System.out.println(b[i]);
        }


    }
}
