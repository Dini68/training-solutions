package _aaa.variable;

import _aaa.Basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Timetable {

    private List<Flight> flights = new ArrayList<>();


    public void readFromFileToLines (BufferedReader br) {
        try {
            String line;
//            skipHeader(br);
            while((line = br.readLine()) != null) {
                String[] temp = line.split(" ");
                String id = temp[0];
                String destination = temp[1];
                String city = temp[2];
                int hour = Integer.parseInt(temp[3].split(":")[0]);
                int minute = Integer.parseInt(temp[3].split(":")[1]);
                Flight fl = new Flight(id, destination, city, LocalTime.of(hour, minute));
                flights.add(fl);
//                System.out.println(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

    private void skipHeader(BufferedReader br) throws IOException {
        br.readLine();
    }

    public  Flight selectFlight (String ident) {
        Flight result = null;
        for(Flight flight : flights)
            if (flight.getId().equals(ident)) {
                result = flight;
            }
        return result;
    }

    public  String moreDestination () {
        String result = null;
        int dep = 0;
        for(Flight flight : flights)
            if (flight.getDestiantion().equals("Departure")) {
                dep ++;
            }
        if (dep > flights.size() / 2) {
            return "Departure";
        }
        if (dep == flights.size() / 2) {
            return "Equals";
        }
        return "Arrival";
    }

    public static void main(String[] args) {
        Timetable tt = new Timetable();
        Path path = Path.of("cities.txt");
        try (BufferedReader br = Files.newBufferedReader(path)){
            tt.readFromFileToLines(br);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
        System.out.println(tt.selectFlight("KS9187"));
        System.out.println(tt.moreDestination());
    }

}
