package pairmatching.model;

import java.util.Arrays;
import pairmatching.exception.CustomIllegalArgumentException;

public enum Option {
    ONE("1"), TWO("2"), THREE("3"), QUIT("Q");

    private final String command;

    Option(String command) {
        this.command = command;
    }

    public static Option from(String input) {
        return Arrays.stream(values()).filter(value -> value.command.equals(input)).findFirst()
                .orElseThrow(() -> new CustomIllegalArgumentException(ErrorMessage.INVALID_INPUT));
    }

}
