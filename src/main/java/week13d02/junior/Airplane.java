package week13d02.junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airplane {

    private List<Flight> flights = new ArrayList<>();

    public List<Flight> getFlights() {
        return flights;
    }

    private Flight processLine(String line) {
        String id = line.split(" ")[0];
        FlightDirection fd = FlightDirection.DEPARTURE;
        if (line.split(" ")[1].equals("Arrival")) {
             fd = FlightDirection.ARRIVAL;
        }
        String city = line.split(" ")[2];
        int hour = Integer.parseInt((line.split(" ")[3].split(":"))[0]);
        int minute = Integer.parseInt((line.split(" ")[3].split(":"))[1]);
        LocalTime time = LocalTime.of(hour, minute);
        return new Flight(id, fd, city, time);
    }

    private void addFlights(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            flights.add(processLine(line));
        }
    }

    public FlightDirection moreDirection () {
        FlightDirection result = null;
        int sum = 0;
        for (Flight f: flights) {
            if (f.getDirection() == FlightDirection.ARRIVAL) {
                sum ++;
            }
        }
        if (sum < flights.size() / 2) {
            return FlightDirection.DEPARTURE;
        }
        return FlightDirection.ARRIVAL;
    }

    public Flight foundFlight(String id) {
        for (Flight f: flights) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        throw new IllegalArgumentException("Wrong flight id");
    }

    public List<Flight> findFlightByCity (String city, FlightDirection fd){
        List<Flight> result = new ArrayList<>();
        for (Flight f: flights) {
            if (f.getCity().equals(city) && f.getDirection() == fd) {
                result.add(f) ;
            }
        }
        if (result.size() == 0) {
            throw new IllegalArgumentException("No such flight");
        }
        return result;
    }

    public Flight earlierDepartingFlight() {
        Flight result = null;
        if (flights == null || flights.size() == 0) {
            throw new IllegalArgumentException("Empty list.");
        }
        int i = 0;
        while (i < flights.size() && result == null) {
            if (flights.get(i).getDirection() == FlightDirection.DEPARTURE) {
                result = flights.get(i);
            }
            i++;
        }
        if (result == null) {
            throw new IllegalArgumentException("No such flight");
        }
        for (Flight f: flights) {
            if (result.getTime().isAfter(f.getTime()) && f.getDirection() == FlightDirection.DEPARTURE) {
                result = f;
            }
        }
        return result;
    }

    public void readFromFile(String fileName) {
        Path path = Path.of(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)){
            addFlights(br);
        } catch (IOException e) {
            throw new IllegalStateException("can read file", e);
        }
    }


}
//    Adott egy fájl melyben egy reptér egy napi munkáját rögzítettük. Adott egy járatszám, az, hogy érkező vagy felszálló gépről van-e szó. A kiinduló/cél város, attól függöen hogy indul vagy érkezik-e a gép és a felszállás/leszállás pontos ideje.
//        ​
//        A fájl:
//        FC5354 Arrival Dublin 18:16
//        KH2442 Departure Berlin 15:54
//        ID4963 Departure Amsterdam 15:22
//        CX8486 Arrival Brussels 10:37
//        EJ9251 Departure  Toronto 11:30
//        KJ7245 Departure Bern 6:18
//        JN6048 Arrival Moscow 18:39
//        MN5047 Arrival Athens 9:35
//        ​
//        Az időpontok szándékosan így szereplnek, nincsenek nullák a számok előtt. Az adatok össze vissza szerepelnek a fájlban.
//        Feladatok:
//        1. Olvasd be a fájl tartalmát a memóriába.
//        2. Határozd meg, hogy induló vagy érkező járatból volt-e több.
//        3. Legyen egy metódus ami járatszám alapján ad vissza egy repülőt.
//        4. Írj egy metódust ami bekér egy várost és azt, hogy az induló vagy érkező járatokat szeretnénk-e. És egy Listába adjuk viassza az összes abba városba induló/érkező repülőt.
//        5. Adjuk vissza a legkorábban induló repülőt!
