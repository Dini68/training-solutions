package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    public List<Integer> getNumbers(int interval, int numbers) {
        return getNumbers(interval,numbers,0);
    }

    public List<Integer> getNumbers(int interval, int numbers, int seed) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= interval; i++) {
           lottoNumbers.add(i);
        }

        Random rnd = new Random();
        if (seed != 0) {
            rnd = new Random(seed);
        }

        List<Integer> lottoList = new ArrayList<>();

        int index = interval;
        int aktNumber = 0;
        while (index > interval - numbers) {
            aktNumber = rnd.nextInt(index);
            lottoList.add(lottoNumbers.get(aktNumber));
            lottoNumbers.remove(aktNumber);
            index --;
        }

        return lottoList;
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers = lottery.getNumbers(90,5);
        System.out.println(lottoNumbers);

        lottoNumbers = lottery.getNumbers(45,6);
        System.out.println(lottoNumbers);

        lottoNumbers = lottery.getNumbers(35,7);
        System.out.println(lottoNumbers);
    }
}
