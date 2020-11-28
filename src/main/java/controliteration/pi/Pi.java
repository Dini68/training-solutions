package controliteration.pi;

public class Pi {


    public String conversionOfPoem(String poem) {
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

        String poem = "Nem a régi s durva közelítés, " +
                "Mi szótól szóig így kijön Betűiket számlálva. " +
                "Ludolph eredménye már, Ha itt végezzük húsz jegyen. " +
                "De rendre kijő még tíz pontosan, " +
                "Azt is bízvást ígérhetem.";

        Pi pi = new Pi();

        System.out.println(pi.conversionOfPoem(poem));
        System.out.println(Math.PI);
    }
}

