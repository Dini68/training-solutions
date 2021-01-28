package collectionslist.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {

    private void isValidLotto(int lotteryType, int ballCount) {
        if (lotteryType == 5 && ballCount == 90) {
            return;
        }
        if (lotteryType == 6 && ballCount == 45) {
            return;
        }
        if (lotteryType == 7 && ballCount == 35) {
            return;
        }
        if (lotteryType >= ballCount ) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        throw new IllegalArgumentException("No such lottery");
    }

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        isValidLotto(lotteryType, ballCount);
        List<Integer> winnerNumbers = new ArrayList<>();
        Random rnd = new Random();
        int[] numbers = new int[ballCount];
        int count = 0;
        int number;
        while (count < lotteryType) {
            number = rnd.nextInt(ballCount);
            if (numbers[number] == 0) {
                numbers[number] = 1;
                winnerNumbers.add(number + 1);
                count ++;
            }
        }
        Collections.sort(winnerNumbers);
        return winnerNumbers;
    }

    public static void main(String[] args) {
        Lottery lotto = new Lottery();
        lotto. selectWinningNumbers(5, 90);
        System.out.println(lotto. selectWinningNumbers(5, 90));
        System.out.println(lotto. selectWinningNumbers(6, 45));
        System.out.println(lotto. selectWinningNumbers(7, 35));
    }
}
