package week15d01.senior;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BitCoin {

    public Map<Integer, Integer> profit (List<Integer> exchange) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        int dayMax = 0;
        int dayMin = 0;
        int actualProfit = 0;
        int maxProfit = exchange.get(1) - exchange.get(0);
        int minProfit = exchange.get(1) - exchange.get(0);
        for (int i = 1; i < exchange.size() ; i++) {
            actualProfit = exchange.get(i) - exchange.get(i-1);
            if (maxProfit < actualProfit) {
                maxProfit = actualProfit;
                dayMax = i;
            }
            if (minProfit > actualProfit) {
                minProfit = actualProfit;
                dayMin = i;
            }
        }
        result.put(dayMax, dayMin);
        return result;
    }

    public static void main(String[] args) {
        BitCoin bc = new BitCoin();
        System.out.println(bc.profit(Arrays.asList(1000, 1100, 1300, 800, 600, 1100, 1000)));
    }
}
