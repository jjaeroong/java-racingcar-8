package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.error.ErrorMessage;

public class InputParser {
    private static final String DELIMITER = ",";

    public static List<String> parseCarNames(final String input) {
        validateNotNull(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public static int parseTryCount(final String input) {
        validateNotNull(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT_FORMAT.message());
        }
    }

    private static void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.message());
        }
    }
}