package week10d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxTravel {

    private List<Integer> passengersInTheBusStop = new ArrayList<>();

    public MaxTravel(List<Integer> passengersInTheBusStop) {
        for (int i : passengersInTheBusStop) {
            if (i > 29 || i < 0) {
                throw new IllegalArgumentException("Max 30 stops.");
            }
        }
        this.passengersInTheBusStop = passengersInTheBusStop;
    }

    public List<Integer> getMaxIndex() {
        List<Integer> maxStops = new ArrayList<>();
        int [] stops = new int[30];
        int maxIndex = 0;
        for (Integer i: passengersInTheBusStop) {
            stops[i] ++;
            if (stops[maxIndex] < stops[i]) {
                maxIndex = i;
            }
        }
        for (int  i = 0; i < 30; i++) {
            if (stops[i] == stops[maxIndex]) {
                maxStops.add(i);
            }
        }
        return maxStops;
        //        return maxIndex;
    }

    public static void main(String[] args) {
        MaxTravel maxTravel = new MaxTravel(Arrays.asList(12,12,0,1,3,4,4));
        System.out.println(maxTravel.getMaxIndex());
        MaxTravel maxTravel2 = new MaxTravel(Arrays.asList(12,12,0,1,3,4,4,12));
        System.out.println(maxTravel2.getMaxIndex());
        MaxTravel maxTravel3 = new MaxTravel(Arrays.asList(12,12,0,0,1,3,4,4));
        System.out.println(maxTravel3.getMaxIndex());
    }
}