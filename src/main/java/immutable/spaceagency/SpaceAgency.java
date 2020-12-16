package immutable.spaceagency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpaceAgency {

    private List<Satellite> satelliteList = new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        if (satellite == null) {
            throw new NullPointerException("Parameter must not be null!");
        }
        satelliteList.add(satellite);
    }
    public Satellite findSatelliteByRegisterIdent(String registerIdent) {
        for (Satellite sa: satelliteList) {
            if (sa.getRegisterIdent().equals(registerIdent)) {
                return sa;
            }
        }
        throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);
    }

    public String toString() {
        return satelliteList.toString();
    }
}
