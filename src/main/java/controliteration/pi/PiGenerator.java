package controliteration.pi;

public class PiGenerator {


    public String getPi() {
        String poem = "Nem a régi s durva közelítés, " +
                "Mi szótól szóig így kijön Betűiket számlálva. " +
                "Ludolph eredménye már, Ha itt végezzük húsz jegyen. " +
                "De rendre kijő még tíz pontosan, " +
                "Azt is bízvást ígérhetem.";

        String stringToPi = "";
      int j = 0;
      boolean first = true;
      for (int i = 0; i < poem.length(); i++) {
          if (!(poem.charAt(i) == ' ') && !(poem.charAt(i) == ',') && !(poem.charAt(i) == '.')) {
              j++;
          } else {
              if (j > 0) {
                  stringToPi += j;
              }
              if (first) {
                  stringToPi +=".";
                  first = false;
              }
              j = 0;
          }
      }

      return stringToPi;
    }

    public static void main(String[] args) {

        PiGenerator pi = new PiGenerator();

        System.out.println(pi.getPi());
        System.out.println(Math.PI);
    }
}

