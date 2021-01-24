package exceptions.polinom.faults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FaultList {

    private ProcessingResult errorType;

    private String lineTest (String line) {
        String lineResult = "";
        String[] datas = line.split(",");
        try {
            Integer.parseInt(datas[0]);
        } catch (NumberFormatException nfe) {
            // megjegyzés
            return "";
        }
        if (datas.length != 3) {
            lineResult = Integer.toString(ProcessingResult.WORD_COUNT_ERROR.getCode());
            return lineResult;
        }
        try {
            Double.parseDouble(datas[1]);
        } catch (NumberFormatException nfe) {
            lineResult = Integer.toString(ProcessingResult.VALUE_ERROR.getCode());
        }
        if (datas[2].charAt(datas[2].length()-1) != '.')  {
            if (lineResult.equals(4)) {
                return Integer.toString(ProcessingResult.VALUE_AND_DATE_ERROR.getCode());
            } else {
                return Integer.toString(ProcessingResult.DATE_ERROR.getCode());
            }
        }
        try {
            String temp = datas[2].replace('.',',');
            String[] numbers = temp.split(",");
            Integer.parseInt(numbers[0]);
            Integer.parseInt(numbers[1]);
            Integer.parseInt(numbers[2]);
        } catch (NumberFormatException nfe) {
            if (lineResult.equals("4")) {
                lineResult = Integer.toString(ProcessingResult.VALUE_AND_DATE_ERROR.getCode());
            } else {
                lineResult = Integer.toString(ProcessingResult.DATE_ERROR.getCode());
            }
        }
        return lineResult;
    }

    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("lines is null");
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (!(lineTest(lines.get(i)).equals(""))) {
                result.add((lines.get(i)).split(",")[0] + "," + lineTest(lines.get(i)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FaultList().lineTest("M12, 34.5, 2014.05.22"));
    }
}
