package exam03re;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {
    public String createHistogram(BufferedReader reader){
        try {
            return processLine(reader);
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read file", ioException);
        }

    }

    private String processLine(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
            int number = Integer.parseInt((line));
            for (int i = 0; i < number; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }
}
