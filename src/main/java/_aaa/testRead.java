package _aaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class testRead {

    public String createHistogram(BufferedReader reader) {
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

    public int sumValues(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("No list");
        }
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        return sum;
    }


    public int minValue(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("No list");
        }
        int minValue = values.get(0);
        for (int i : values) {
            if (minValue > i) {
                minValue = i;
            }
        }
        return minValue;
    }

    public int maxValue(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("No list");
        }
        int maxValue = values.get(0);
        for (int i : values) {
            if (maxValue < i) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    public double averageValues(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("No list");
        }
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        return (double) sum / values.size();
    }



    public Object isFindByName(List<String> names, String name) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("No list");
        }
        for (Object o : names) {
            if (o.equals(name)) {
                return o;
            }
        }
        throw new IllegalArgumentException("not such name between names.");
    }

    public static void main(String[] args) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(testRead.class.getResourceAsStream("histogram.txt")));
//        System.out.println(new testRead().createHistogram(reader));
        System.out.println(new testRead().sumValues(Arrays.asList(1, 2, 5, 8)));
        System.out.println(new testRead().maxValue(Arrays.asList(1, 2, 5, 8)));
        System.out.println(new testRead().minValue(Arrays.asList(1, 2, 5, 8)));
        System.out.println(new testRead().averageValues(Arrays.asList(3, 2, 5, 9)));
    }
}
