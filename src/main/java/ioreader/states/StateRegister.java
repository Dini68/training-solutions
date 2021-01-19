package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    private List<State> states = new ArrayList<>();

    public List<State> getStates() {
        return new ArrayList<>(states);
    }

    public void readStatesFromFile(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/"+fileName))){
            String line;
            String stateName;
            String capital;
            while ((line = reader.readLine()) != null) {
                stateName = line.substring(0, line.indexOf('-'));
                capital = line.substring(line.indexOf('-') + 1, line.length());
                states.add(new State(stateName, capital));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }

    public String findCapitalByStateName(String stateName) {
        for (State st: states) {
            if (st.getStateName().equals(stateName)) {
                return st.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }
}
