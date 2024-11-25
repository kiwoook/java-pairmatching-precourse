package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.model.Pair;

class PairTest {

    @Test
    @DisplayName("순서가 달라도 같은 이름이라면 페어이다.")
    void test1() {
        String name1 = "user1";
        String name2 = "user2";

        Pair pair1 = Pair.create(name1, name2);
        Pair pair2 = Pair.create(name2, name1);

        assertThat(pair1).isEqualTo(pair2);
    }
}
