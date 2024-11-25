package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.enums.Course;
import pairmatching.model.Crew;

class CrewTest {

    @Test
    @DisplayName("과정이 같으면 true를 반환한다.")
    void test1() {
        Crew crew = Crew.of("기욱", Course.BACKEND);

        assertThat(crew.sameCourse(Course.BACKEND)).isTrue();
    }

    @Test
    @DisplayName("과정이 다르면 false를 반환한다.")
    void test2() {
        Crew crew = Crew.of("기욱", Course.BACKEND);

        assertThat(crew.sameCourse(Course.FRONTEND)).isFalse();
    }
}
