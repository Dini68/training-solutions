package week08d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LotteryTest {

    @Test
    public void getNumbers90_5Test() {
        List<Integer> lottoList = Arrays.asList(18, 90, 44, 37, 20);
        Lottery lottery = new Lottery();
        assertEquals(lottoList, lottery.getNumbers(90,5,5));
    }
    @Test
    public void getNumbers45_6Test() {
        List<Integer> lottoList = Arrays.asList(17, 9, 4, 22, 32, 5);
        Lottery lottery = new Lottery();
        assertEquals(lottoList, lottery.getNumbers(45,6,6));
    }
    @Test
    public void getNumbers35_7Test() {
        List<Integer> lottoList = Arrays.asList(32, 27, 22, 1, 24, 6, 25);
        Lottery lottery = new Lottery();
        assertEquals(lottoList, lottery.getNumbers(35,7,7));
    }
}
