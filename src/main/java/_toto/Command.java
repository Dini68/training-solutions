package _toto;

import java.io.File;

public interface Command {

    boolean shouldHandle(String command);

    void process (File workingDirectory, String command);
}
