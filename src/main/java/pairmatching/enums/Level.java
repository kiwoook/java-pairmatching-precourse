package pairmatching.enums;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    // 이거 만들 줄 모름
    public static Level from(String input) {
        return Arrays.stream(values())
                .filter(level -> level.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("정상적인 입력을 해주세요."));
    }

    public String getName() {
        return name;
    }


}