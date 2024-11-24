package pairmatching.enums;

import java.util.Arrays;

public enum Option {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    QUIT("Q");

    private final String input;

    Option(String input) {
        this.input = input;
    }

    public static Option from(String input) {
        return Arrays.stream(values())
                .filter(option -> option.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("정상적인 입력을 해주세요"));
    }
}
