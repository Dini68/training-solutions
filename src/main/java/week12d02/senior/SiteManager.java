package week12d02.senior;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SiteManager {

    private List<Site> sites = new ArrayList<>();

    public List<Site> getSites() {
        return sites;
    }

    public SiteManager(String fileName) {

        System.out.println("Max házszám: " + readSitesFromFile(fileName));
    }

    public int readSitesFromFile (String fileName) {
        int maxNumberOfHouse;
        Path file = Path.of(fileName);
        try {
            List<String> lines = new ArrayList<>();
            lines = Files.readAllLines(file);
            int streetLengthOdd = 0;
            int streetLengthEven = 0;
            String side;
            String width;
            String color;
            String number = "";
            int countOdd = 1;
            int countEven = 2;
            for (String l: lines) {
                String[] arr = l.split(" ");
                side = arr[0];
                if (!side.equals("0") && !side.equals(("1"))) {
                    throw new IllegalArgumentException("It can be 0 or 1");
                }
                width = arr[1];
                int wValue = Integer.parseInt(width);
                if (wValue < 8 || wValue > 20) {
                    throw new IllegalArgumentException("It can be between 8 and 20");
                }
                color = arr[2];

                if (side.equals("0")) {
                    number = Integer.toString(countEven);
                    countEven +=2;
                    streetLengthEven +=wValue;
                }
                if (side.equals("1")) {
                    number = Integer.toString(countOdd);
                    countOdd +=2;
                    streetLengthOdd +=wValue;
                }
                sites.add(new Site(side, width, color, number));
            }
            if (streetLengthEven > 1000 || streetLengthOdd > 1000) {
                throw new IllegalArgumentException("It can be up to 1000");
            }
            maxNumberOfHouse = Math.max(countEven, countOdd) - 2;
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
        return maxNumberOfHouse;
    }


    public List<Site> soldSiteShortFromWidth() {
        List<Site> sitesCopy = new ArrayList<>();
        int count = 0;
        for (int i = 20; i >= 8; i--) {
            for (int j = 0; j < sites.size(); j++) {
                if (Integer.parseInt(sites.get(j).getWidth()) == i) {
                    sitesCopy.add(sites.get(j));
                    count++;
                }
            }
        }
        return sitesCopy;
    }

    public void writeOddStreetToFile(String fileName){
        Path file = Path.of(fileName);
        StringBuilder street = new StringBuilder();
        for (Site s : sites) {
            if (s.getSide().equals("1")) {
                street.append("(" + s.getNumber() + ")");
                for (int i = 0; i < Integer.parseInt(s.getWidth()); i++) {
                    street.append(s.getColor());
                }
            }
        }
        try {
            Files.writeString(file, street);
        } catch (IOException e) {
            throw new IllegalStateException("can not write file", e);
        }
    }

    public static void main(String[] args) {
        SiteManager siteManager = new SiteManager("kerites.txt");
        for (int i = 0; i < siteManager.sites.size(); i++) {
            System.out.println(siteManager.soldSiteShortFromWidth().get(i));
        }
        System.out.println(siteManager.getSites().toString());
        siteManager.writeOddStreetToFile("utcakep.txt");

    }

}
