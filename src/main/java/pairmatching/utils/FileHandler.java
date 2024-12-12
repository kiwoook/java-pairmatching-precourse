package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.model.Crew;

public class FileHandler {

    private static final String BACKEND_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_PATH = "src/main/resources/frontend-crew.md";

    public List<Crew> getBackendCrews() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BACKEND_PATH))) {
            return bufferedReader.lines()
                    .map(Crew::from)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Crew> getFrontendCrews() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FRONTEND_PATH))) {
            return bufferedReader.lines()
                    .map(Crew::from)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
