package pairmatching.model;

import java.util.Arrays;
import pairmatching.exception.CustomIllegalArgumentException;

public enum Mission {

    RACE("자동차 경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL("숫자야구게임", Level.LEVEL1),
    CART("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),
    IMPROVEMENT("성능개선", Level.LEVEL4),
    DEPLOYMENT("배포", Level.LEVEL4);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission of(String missionName, Level level) {
        return Arrays.stream(values()).filter(value -> value.isMission(missionName, level)).findFirst()
                .orElseThrow(() -> new CustomIllegalArgumentException(ErrorMessage.INVALID_INPUT));
    }


    private boolean isMission(String missionName, Level level) {
        return this.name.equals(missionName) && this.level.equals(level);
    }
}
