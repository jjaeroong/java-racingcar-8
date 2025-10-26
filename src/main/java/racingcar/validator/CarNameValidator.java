package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.error.ErrorMessage;

public class CarNameValidator {
    public void validate(final List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NO_PARTICIPANTS.message());
        }
        validateDuplicate(names);
    }

    private void validateDuplicate(final List<String> names) {
        Set<String> nameSet = new HashSet<>();
        for (String name : names) {
            validateUniqueName(nameSet, name);
        }
    }

    private void validateUniqueName(Set<String> nameSet, String name) {
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.message());
        }
    }
}
