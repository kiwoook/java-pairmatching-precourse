package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.enums.Course;
import pairmatching.model.Crew;

public class FileHandler {

    private static final String BACKEND_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_PATH = "src/main/resources/frontend-crew.md";

    // 백엔드 크루원들을 저장하는 메서드
    public List<Crew> getBackendCrews() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BACKEND_PATH))) {
            return bufferedReader.lines()
                    .map(line -> Crew.of(line, Course.BACKEND))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    // 프론트 엔드 크루원들을 저장하는 메서드
    public List<Crew> getFrontendCrews() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FRONTEND_PATH))) {
            return bufferedReader.lines()
                    .map(line -> Crew.of(line, Course.FRONTEND))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
