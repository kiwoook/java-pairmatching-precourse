package pairmatching.model;

public enum ErrorMessage {
    INVALID_INPUT("잘못된 입력입니다. 다시 입력해 주세요."),
    INVALID_MATCHING("매칭을 시도할 수 없습니다!"),
    NOT_FOUND("매칭 이력이 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}