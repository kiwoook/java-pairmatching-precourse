package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import pairmatching.model.CourseMission;

class CourseMissionTest {

    @ParameterizedTest
    @DisplayName("입력 변환 테스트")
    @ValueSource(strings = {"백엔드, 레벨1, 자동차경주",
            "백엔드, 레벨2, 장바구니",
            "프론트엔드, 레벨4, 성능개선"
    })
    void test1(String input) {
        CourseMission courseMission = CourseMission.parseInput(input);

        assertThat(courseMission).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("잘못된 입력시 에러를 던진다.")
    @EmptySource
    @ValueSource(strings = {"프론트, 레벨2, 장바구니",
            "백엔드, 레벨1, 장바구니",
            "백엔드, 레벨5, 장바구니",
            "백엔드,레벨1,자동차경주",
            "백엔드, 1, 자동차경주",
            "백엔드, 레벨2, 지하철노선"
    })
    void test2(String input) {
        assertThatThrownBy(() -> CourseMission.parseInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
