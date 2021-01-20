package week12d02.senior2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SiteManager {

    private List<Site> sites = new ArrayList<>();

    private int oddSide = 1;
    private int evenSide = 2;

    public List<Site> getSites() {
        return new ArrayList<>(sites);
    }

    public void addSite(String line) {
        String[] arr = line.split(" ");
        int side = Integer.parseInt(arr[0]);
        int width = Integer.parseInt(arr[1]);
        int number = 0;
        if (side == 0) {
            number = evenSide;
            evenSide += 2;
        }
        if (side == 1) {
            number = oddSide;
            oddSide += 2;
        }
        sites.add(new Site(side, Integer.parseInt(arr[1]), arr[2], number));
    }

    public void readFromFileToStrings(String fileName) {
        Path path = Path.of(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                addSite(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("can not file", e);
        }
    }

    public List<Site> shortSitesByWith() {
        List<Site> shortSites = new ArrayList<>();
        for (int i = 20; i >= 8; i--) {
            for (Site s: sites) {
                if (s.getWidth() == i) {
                    shortSites.add(s);
                }
            }
        }
        return shortSites;
    }

    public int lastSiteNumber() {
        return sites.get(sites.size()-1).getNumber();
    }

    public void writeOddSideToFile () {
        Path path = Path.of("keritesrajz.txt");
        String line;
        String fence = "";
        try (BufferedWriter bw = Files.newBufferedWriter(path)){
            for (Site si: sites) {
                if (si.getSide() == 1) {
                    for (int i = 0; i < si.getWidth(); i++) {
                        fence += si.getColor();
                    }
                    line = "(" + si.getNumber() + ")" + fence;
                    bw.write(line);
                    fence = "";
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

    public int allSitesWidthMax() {
        int allFenceWidth = 0;
        int oddWidth = 0;
        int evenWidth = 0;
        for (Site si : sites) {
            if (si.getSide() == 0) {
                evenWidth += si.getWidth();
            }
            if (si.getSide() == 1) {
                oddWidth += si.getWidth();
            }
        }
        allFenceWidth = Math.max(evenWidth, oddWidth);
        if ( allFenceWidth > 1000) {
            throw new IllegalArgumentException("All Fence width can be max 1000" + allFenceWidth);
        }
        return allFenceWidth;
    }

    public static void main(String[] args) {
        SiteManager siteManager = new SiteManager();
        siteManager.readFromFileToStrings("kerites.txt");
//        System.out.println(siteManager.getSites().toString());
        System.out.println(siteManager.shortSitesByWith());
        System.out.println("Az utolsó eladott telek házszáma: " + siteManager.lastSiteNumber());
        siteManager.writeOddSideToFile();
        System.out.println("A kerítés max hossza: " + siteManager.allSitesWidthMax());
    }
}
