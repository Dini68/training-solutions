package week12d03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NumberStat {

    private List<Integer> numbers = new ArrayList<>();

    public void numbersReadFromFile (String fileName) {
        List<String> numbersStr;
        Path file = Path.of(fileName);
        try {
            numbersStr = Files.readAllLines(file);

            if (numbersStr.get(0).isBlank()) {
                throw new IllegalArgumentException("list is empty");
            }
            String[] num;
            for (String nst: numbersStr) {
                num = nst.split(",");
                for(int i = 0; i < num.length; i++) {
                    numbers.add(Integer.parseInt(num[i]));
                }
            }
            if (numbers.size() == 0) {
                throw new IllegalArgumentException("List is empty");
            }
        } catch (IOException e) {
            throw new IllegalStateException("can not file", e);
        }
    }

    public int minNumber1X() {
        int minValue = numbers.get(0);
        int maxValue = numbers.get(0);
        for (int nu: numbers) {
            if (minValue > nu) {
               minValue = nu;
            }
            if (maxValue < nu) {
               maxValue = nu;
            }
        }
        int count;
        for (int i = minValue; i <= maxValue; i++) {
            count = 0;
            for (int nu: numbers) {
                if (nu == i) {
                    count ++;
                }
            }
            if (count==1) {
                return i;
            }
        }
        throw new IllegalArgumentException("wrong list");
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public static void main(String[] args) {
        NumberStat numberStat = new NumberStat();
        numberStat.numbersReadFromFile("numbers.txt");
        System.out.println(numberStat.minNumber1X());
    }
}
