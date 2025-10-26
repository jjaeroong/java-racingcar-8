package racingcar.model;

import racingcar.error.ErrorMessage;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotBlank(name);
        validateLength(name);
    }

    private void validateNotBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME.message());
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_NAME_LENGTH.message());
        }
    }

    public String getValue() {
        return name;
    }
}

