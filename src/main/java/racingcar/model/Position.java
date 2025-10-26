package racingcar.model;

import java.util.Objects;
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

    public Position moveForward() {
        return new Position(this.value + 1);
    }


    public String toDisplayBar() {
        return "-".repeat(value);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}