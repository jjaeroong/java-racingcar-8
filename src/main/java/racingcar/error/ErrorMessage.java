package racingcar.error;

public enum ErrorMessage {
    INVALID_NAME("자동차 이름이 유효하지 않습니다."),
    EXCEED_NAME_LENGTH("자동차 이름은 5자 이하여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
