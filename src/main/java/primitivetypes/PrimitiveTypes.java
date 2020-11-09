package primitivetypes;

public class PrimitiveTypes {

    public String toBinaryString(int n){

        String s = "";
        int m = 0;

        while (n > 0) {
            m = n % 2;
            n = n / 2;
            s = m + s;
        }

        while (s.length()<32) {
            s = 0 + s;
        }

        return s;
    }
}
