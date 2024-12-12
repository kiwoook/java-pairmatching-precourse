package pairmatching.model;

import java.util.Arrays;

public enum Confirmation {

    YES("네"),
    NO("아니오");

    private final String value;

    Confirmation(String value) {
        this.value = value;
    }

    public static Confirmation of(String input) {
        return Arrays.stream(values())
                .filter(confirmation -> confirmation.value.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage()));
    }

}
