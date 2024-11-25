package pairmatching.utils;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.model.Crew;

class FileHandlerTest {

    private final FileHandler fileHandler = new FileHandler();

    @Test
    @DisplayName("백엔드 출력 테스트")
    void test1() {
        List<Crew> backendCrews = fileHandler.getBackendCrews();

        System.out.println(backendCrews);
    }

    @Test
    @DisplayName("프론트엔드 출력 테스트")
    void test2() {
        List<Crew> frontendCrews = fileHandler.getFrontendCrews();

        System.out.println(frontendCrews);
    }
}
