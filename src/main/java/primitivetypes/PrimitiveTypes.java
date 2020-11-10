package primitivetypes;

public class PrimitiveTypes {

    public String toBinaryString(int n){

        String s = "";
        int m = 0;

        for (int j=0; j<32; j++) {
            m = n % 2;
            n = n / 2;
            s = m + s;
        }

/*        while (n > 0) {
            m = n % 2;
            n = n / 2;
            s = m + s;
        }

        while (s.length()<32) {
            s = 0 + s;
        }
*/
        return s;
    }
}
