package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.error.ErrorMessage;
import racingcar.model.CarName;
import racingcar.validator.CarNameValidator;

class CarNameTest {

    private final CarNameValidator validator = new CarNameValidator();

    @Test
    @DisplayName("유효한 이름으로 CarName을 생성한다")
    void createCarNameWithValidName() {
        // given
        String validName = "pobi";

        // when
        CarName carName = new CarName(validName);

        // then
        assertThat(carName.getValue()).isEqualTo(validName);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열로 CarName 생성 시 예외가 발생한다")
    void createCarNameWithNullOrEmpty(String invalidName) {
        assertThatThrownBy(() -> new CarName(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NAME.message());
    }

    @ParameterizedTest
    @ValueSource(strings = {"jjaerooog", "jajajjaero"})
    @DisplayName("5자를 초과하는 이름으로 CarName 생성 시 예외가 발생한다")
    void createCarNameWithTooLongName(String longName) {
        assertThatThrownBy(() -> new CarName(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EXCEED_NAME_LENGTH.message());
    }

    @Test
    @DisplayName("5자 이하의 이름은 정상적으로 생성된다")
    void createCarNameWithMaxLength() {
        // given
        String maxLengthName = "12345";

        // when
        CarName carName = new CarName(maxLengthName);

        // then
        assertThat(carName.getValue()).isEqualTo(maxLengthName);
    }

    @Test
    @DisplayName("중복된 이름이 있으면 예외가 발생한다")
    void validateDuplicateNames() {
        // given
        List<String> duplicateNames = Arrays.asList("pobi", "crong", "pobi");

        // when & then
        assertThatThrownBy(() -> validator.validate(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_NAME.message());
    }
}

