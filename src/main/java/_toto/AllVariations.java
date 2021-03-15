package _toto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AllVariations {

    private final static int MAX_SOR = 13;

    private List<String> tips = new ArrayList<>();

    public List<String> getTips() {
        return tips;
    }

    public void tipsWriteToFile(String fileName) {
        Path path = Path.of(fileName);
        try {
            Files.write(path, getTips());
        } catch (IOException e) {
            throw new IllegalStateException("not write file", e);
        }
    }

    public void addtips() {
        String column;
        String prefix = "";
        for (int i = 0; i < MAX_SOR; i++) {
            prefix += "1";
        }
        StringBuilder sb;
        int count1;
        int count1Is0 = 0;
        int count1Is1 = 0;
        int count1Is2 = 0;
        int count1Is3 = 0;
        int count1Is4 = 0;
        int count1Is5 = 0;
        int count1Is6 = 0;
        int count1Is7 = 0;
        int count1Is8 = 0;
        int count1Is9 = 0;
        int count1Is10 = 0;
        int count1Is11 = 0;
        int count1Is12 = 0;
        int count1Is13 = 0;
        double count1Is0sz = 0;
        double count1Is1sz = 0;
        double count1Is2sz = 0;
        double count1Is3sz = 0;
        double count1Is4sz = 0;
        double count1Is5sz = 0;
        double count1Is6sz = 0;
        double count1Is7sz = 0;
        double count1Is8sz = 0;
        double count1Is9sz = 0;
        double count1Is10sz = 0;
        double count1Is11sz = 0;
        double count1Is12sz = 0;
        double count1Is13sz = 0;
        int count2;
        int countX;
        int count1Eu;
        int count2Eu;
        int countXEu;
        int count1EuMax;
        int count2EuMax;
        int countXEuMax;
        for (int i = 0; i < Math.pow(3, MAX_SOR); i++) {
            sb = new StringBuilder();
            column = Integer.toUnsignedString(i, 3);
            count1 = MAX_SOR - column.length();
            count2 = 0;
            countX = 0;
            count1Eu = count1;
            count2Eu = 0;
            countXEu = 0;
            count1EuMax = count1;
            count2EuMax = 0;
            countXEuMax = 0;
            sb.append(prefix, 0, count1);
            for (int j = 0; j < column.length(); j++) {
                if (column.charAt(j) == '0') {
                    count1++;
                    count1Eu++;
                    if (count2EuMax < count2Eu) {
                        count2EuMax = count2Eu;
                    }
                    if (countXEuMax < countXEu) {
                        countXEuMax = countXEu;
                    }
                    count2Eu = 0;
                    countXEu = 0;
                    sb.append('1');
                }
                if (column.charAt(j) == '1') {
                    count2++;
                    count2Eu++;
                    if (count1EuMax < count1Eu) {
                        count1EuMax = count1Eu;
                    }
                    if (countXEuMax < countXEu) {
                        countXEuMax = countXEu;
                    }
                    count1Eu = 0;
                    countXEu = 0;
                    sb.append('2');
                }
                if (column.charAt(j) == '2') {
                    countX ++;
                    countXEu++;
                    if (count1EuMax < count1Eu) {
                        count1EuMax = count1Eu;
                    }
                    if (count2EuMax < count2Eu) {
                        count2EuMax = count2Eu;
                    }
                    count1Eu = 0;
                    count2Eu = 0;
                    sb.append('x');
                }
            }
            if (count1EuMax < count1Eu) {
                count1EuMax = count1Eu;
            }
            if (count2EuMax < count2Eu) {
                count2EuMax = count2Eu;
            }
            if (countXEuMax < countXEu) {
                countXEuMax = countXEu;
            }
            if (count1 == 0) {
                count1Is0 ++;
            }
            if (count1 == 1) {
                count1Is1 ++;
            }
            if (count1 == 2) {
                count1Is2 ++;
            }
            if (count1 == 3) {
                count1Is3 ++;
            }
            if (count1 == 4) {
                count1Is4 ++;
            }
            if (count1 == 5) {
                count1Is5 ++;
            }
            if (count1 == 6) {
                count1Is6 ++;
            }
            if (count1 == 7) {
                count1Is7 ++;
            }
            if (count1 == 8) {
                count1Is8 ++;
            }
            if (count1 == 9) {
                count1Is9 ++;
            }
            if (count1 == 10) {
                count1Is10 ++;
            }
            if (count1 == 11) {
                count1Is11 ++;
            }
            if (count1 == 12) {
                count1Is12 ++;
            }
            if (count1 == 13) {
                count1Is13 ++;
            }
            tips.add(i + 1 + " " + sb.toString() + " " + count1 + " " + count2 + " " + countX + " " +
                     count1EuMax + " " + count2EuMax + " " + countXEuMax);
        }
        count1Is0sz = Math.round(count1Is0 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 0: " + count1Is0 + " " + count1Is0sz + "%");
        count1Is1sz = Math.round(count1Is1 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 1: " + count1Is1 + " " + count1Is1sz + "%");
        count1Is2sz = Math.round(count1Is2 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 2: " + count1Is2 + " " + count1Is2sz + "%");
        count1Is3sz = Math.round(count1Is3 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 3: " + count1Is3 + " " + count1Is3sz + "%");
        count1Is4sz = Math.round(count1Is4 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 4: " + count1Is4 + " " + count1Is4sz + "%");
        count1Is5sz = Math.round(count1Is5 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 5: " + count1Is5 + " " + count1Is5sz + "%");
        count1Is6sz = Math.round(count1Is6 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 6: " + count1Is6 + " " + count1Is6sz + "%");
        count1Is7sz = Math.round(count1Is7 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 7: " + count1Is7 + " " + count1Is7sz + "%");
        count1Is8sz = Math.round(count1Is8 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 8: " + count1Is8 + " " + count1Is8sz + "%");
        count1Is9sz = Math.round(count1Is9 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 9: " + count1Is9 + " " + count1Is9sz + "%");
        count1Is10sz = Math.round(count1Is10 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 10: " + count1Is10 + " " + count1Is10sz + "%");
        count1Is11sz = Math.round(count1Is11 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 11: " + count1Is11 + " " + count1Is11sz + "%");
        count1Is12sz = Math.round(count1Is12 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 12: " + count1Is12 + " " + count1Is12sz + "%");
        count1Is13sz = Math.round(count1Is13 / Math.pow(3, MAX_SOR) * 100000)/1000.0;
        tips.add("1-esek száma 13: " + count1Is13 + " " + count1Is13sz + "%");
    }

    public static void main(String[] args) {
        AllVariations av = new AllVariations();
        av.addtips();
        for(String s: av.getTips()) {
            System.out.println(s);
        }
        av.tipsWriteToFile("totovariations.txt");
    }
}
