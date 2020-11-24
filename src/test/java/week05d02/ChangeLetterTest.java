package week05d02;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ChangeLetterTest {

    @Test
    public void test() {
        assertEquals("* pr*gr*m*zás *l*pj**t m*gért*n* f*nt*s lépés.",
                new ChangeLetter().changeVowels("A programozás alapjait megérteni fontos lépés."));
        assertEquals("*z * m*nd*t *nn*ntől N*GY B*TŰS. * M*L V*D* jó cs*p*t.",
                new ChangeLetter().changeVowels("Ez a mondat innentől NAGY BETŰS. A MOL VIDI jó csapat."));
        assertEquals("*z *z *t*lsó t*sztm*nd*t. T*l*f*nszám: 0124-56-78",
                new ChangeLetter().changeVowels("Ez az utolsó tesztmondat. Telefonszám: 0124-56-78"));
    }
}
