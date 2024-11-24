package pairmatching.enums;

public enum Confirmation {
    YES("네"),
    NO("아니오");

    private final String input;

    Confirmation(String input) {
        this.input = input;
    }

    public static Confirmation from(String input) {
        if (input.equals(YES.input)) {
            return YES;
        }

        if (input.equals(NO.input)) {
            return NO;
        }

        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

}
