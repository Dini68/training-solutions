package _aaa.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Histogram {

    public String createHistogram (BufferedReader reader) {
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                lineProcess(sb, line);
                System.out.println(line);
            }
            return sb.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read fil", ioe);
        }
    }

    private void lineProcess(StringBuilder sb, String line) {
        int starNumber = Integer.parseInt(line);
        for (int i = 0; i < starNumber; i++) {
            sb.append('*');
        }
        sb.append("\n");
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(Histogram.class.getResourceAsStream("histogram.txt")));
        System.out.println(new Histogram().createHistogram(reader));
    }
}
//    Hisztogram
//    Olvass be egy szöveges fájlt soronként, melyben soronkont számok vannak.
//    Majd hozz létre egy stringet, mely ugyanennyi sort tartalmaz,
//    és annyi csillagot ír ki egymás mellé soronkont, amennyi a bemeneti fájlban lévő szám.
//
//    Azaz a bemeneti fájl:
//
//            3
//            4
//            1
//            2
//    A létrehozott String:
//
//            ***
//            ****
//            *
//            **
//    Figyelj, hogy az algoritmusod lehetőleg hatékony legyen!
//
//    A Histogram osztályba dolgozz, tesztje HistogramTest. Minden sor után legyen sortörés, az utolsó után is.
