package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.model.Pairs;

class PairsTest {

    @Test
    @DisplayName("페어 묶음 중복 테스트")
    void test1() {
        List<String> shuffleList1 = Arrays.asList("user1", "user2", "user3", "user4");
        List<String> shuffleList2 = Arrays.asList("user2", "user1", "user5", "user4");

        Pairs pairs1 = Pairs.create(shuffleList1);
        Pairs pairs2 = Pairs.create(shuffleList2);

        List<Pairs> comparePairsList = Collections.singletonList(pairs2);

        assertThat(pairs1.checkDuplicatedPairsList(comparePairsList)).isTrue();
    }
}
