package math.round;

import java.util.Random;

public class RoundingAnomaly {

    public double[] randomNumbers(int size, double max, int scale) {
        double[] rndNumbers = new double[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            rndNumbers[i] = Math.round(rnd.nextDouble() * max * 100000) / 100000.0;
        }
        return rndNumbers;
    }
    public double roundAfterSum(double[] numbers) {
        double roundAfterSum = 0;
        for (int i = 0; i < 1000; i++) {
            roundAfterSum += numbers[i];
        }
        return Math.round(roundAfterSum);
    }
    public double sumAfterRound(double[] numbers) {
        double sumAfterRound = 0;
        for (int i = 0; i < 1000; i++) {
            sumAfterRound += Math.round(numbers[i]);
        }
        return sumAfterRound;
    }
    public double difference(int size, double max, int scale) {
        double difference = 0;
        double[] numbers = new double[1000];
        numbers = randomNumbers(size, max, scale);
        difference = roundAfterSum(numbers) - sumAfterRound(numbers);
        return difference;
    }
    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();
        double diff = 0;
        for (int i = 0; i < 100; i++) {
            diff += roundingAnomaly.difference(1000, 1000000,5);
        }
        System.out.println(diff / 100);
    }
}
