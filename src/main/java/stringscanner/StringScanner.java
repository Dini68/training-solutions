package stringscanner;

import java.util.Scanner;

public class StringScanner {

    public boolean isEmpty(String str) {
        return (str == null) || str.equals("");
    }

    public int readAndSumValues(String intString, String delimiter) {
        if (isEmpty(intString) || isEmpty(delimiter)) {
            throw new IllegalArgumentException("Üres, vagy null paraméter!");
        }
        Scanner scanner = new Scanner(intString).useDelimiter(delimiter);
        int sum = 0;
        while (scanner.hasNext()) {
            sum += Integer.parseInt(scanner.next());
        }
        return sum;
    }

    public int readAndSumValues(String intString) {
        if (isEmpty(intString)) {
            throw new IllegalArgumentException("Üres, vagy null paraméter!");
        }
        return this.readAndSumValues(intString, " ");
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || isEmpty(word)) {
            throw new IllegalArgumentException("Üres, vagy null paraméter!");
        }
        Scanner scanner = new Scanner(text);
        StringBuilder sb = new StringBuilder();
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.contains(word)) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

}
