package racingcar.model;

import racingcar.error.ErrorMessage;

public class Position {
    private static final int INITIAL_POSITION = 0;
    private final int value;

    public Position(int value) {
        validateNonNegative(value);
        this.value = value;
    }

    public static Position initial() {
        return new Position(INITIAL_POSITION);
    }

    private void validateNonNegative(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.message());
        }
    }

}