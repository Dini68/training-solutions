package week11d01;

public class DivisorFinder {

    public int findDivisors(int n) {
        int numberOfDivisors = 0;
        int digit = 0;
        int number = n;
        while (number > 0) {
            digit = number % 10;
            if (digit != 0 && n % digit == 0) {
                numberOfDivisors++;
            }
            number = number / 10;
        }
        return numberOfDivisors;
    }
}