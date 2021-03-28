package week10d01.senior;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class HikingFile {

    public static final String SEPARATED_CHARACTER = ", ";

    private double preHeight = -1;

    public ElevationDate getElevation(InputStream is) {
        ElevationDate ev = new ElevationDate();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                calculateElevation(ev, line);
            }
            return ev;
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private void calculateElevation(ElevationDate ev, String line) {
        String[] parts = line.split(SEPARATED_CHARACTER);
        double actHeight = Double.parseDouble(parts[2]);
        if (preHeight != -1) {
            if (preHeight < actHeight) {
                ev.addIncrease(actHeight - preHeight);
            } else {
                ev.addDecrease(preHeight - actHeight);
            }
        }
        preHeight = actHeight;
    }

}
