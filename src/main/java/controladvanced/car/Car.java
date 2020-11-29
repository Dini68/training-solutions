package controladvanced.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length != 4) {
                continue;
            }
            if (parts[0].length()!= 7) {
                continue;
            }
            if (parts[0].indexOf('-') == -1) {
                continue;
            }
            if ((Integer.parseInt(parts[1]) < 1970) || (Integer.parseInt(parts[1]) > 2020)) {
                continue;
            }
            validLines.add(line);
        }
        return validLines;
    }

    public static void main(String[] args) {
        Car car = new Car();

        List<String> carList = Arrays.asList(
                "ABC-123;2007;Volvo;red",
                "ABC 123;2007;Hyundai;red",
                "ABC-123;2007BMW;red",
                "ABC-123;2107;Suziuki;black",
                "ABC-123;2007;Trabant;red",
                "ABC-123;2007;Mercdes;blue",
                "ABC-123;2007;VW;red",
                "ABC-1234;2007;Lada;white",
                "ABC-123;2007;Skoda;red",
                "ABC-123;1007;Citroen;green",
                "ABC-123;2007;Renault;red");
        List<String> filterList = new ArrayList<>();
        filterList = car.filterLines(carList);
        System.out.println(filterList.size());
        System.out.println(filterList.toString());
    }
}
//"ABC-123;2007;Volvo;red"