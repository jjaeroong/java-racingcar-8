package racingcar.error;

public enum ErrorMessage {
    INVALID_NAME("자동차 이름이 유효하지 않습니다."),
    EXCEED_NAME_LENGTH("자동차 이름은 5자 이하여야 합니다."),
    NULL_INPUT("입력값이 null입니다."),
    NO_PARTICIPANTS("참가자가 없습니다."),
    DUPLICATE_NAME("중복된 자동차 이름이 있습니다."),
    INVALID_TRY_COUNT_FORMAT("시도 횟수는 숫자여야 합니다."),
    INVALID_TRY_COUNT("시도 횟수는 1 이상이어야 합니다."),
    INVALID_POSITION("위치는 0 이상이어야 합니다."),
    NULL_CAR("비교할 자동차가 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
