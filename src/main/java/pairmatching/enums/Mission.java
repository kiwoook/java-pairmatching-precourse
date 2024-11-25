package pairmatching.enums;

import java.util.Arrays;

public enum Mission {

    RACE("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL("숫자야구게임", Level.LEVEL1),
    CART("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL3),
    IMPROVEMENT("성능개선", Level.LEVEL4),
    DEPLOYMENT("배포", Level.LEVEL4);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission of(String inputName, Level inputLevel) {
        return Arrays.stream(values())
                .filter(mission -> mission.isMatch(inputName, inputLevel))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 미션명입니다!"));
    }

    private boolean isMatch(String inputName, Level inputLevel) {
        return this.name.equals(inputName) && this.level.equals(inputLevel);
    }

    public Level getLevel() {
        return level;
    }
}
