package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorMessage;
import racingcar.model.Cars;
import racingcar.validator.CarNameValidator;

public class CarTest {
    private final CarNameValidator validator = new CarNameValidator();

    @Test
    @DisplayName("이름 리스트로 차를 생성할 수 있다")
    void createCarsFromNames() {
        // given
        List<String> names = Arrays.asList("pobi", "crong", "honux");

        // when
        Cars cars = Cars.from(names);

        // then
        assertThat(cars.toDisplayStrings()).hasSize(3);
    }
    @Test
    @DisplayName("빈 리스트는 예외가 발생한다")
    void validateEmptyList() {
        // given
        List<String> emptyNames = Arrays.asList();

        // when & then
        assertThatThrownBy(() -> validator.validate(emptyNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NO_PARTICIPANTS.message());
    }

    @Test
    @DisplayName("우승자 이름들을 쉼표로 구분하여 반환한다")
    void getWinnerNames() {
        // given
        List<String> names = Arrays.asList("pobi", "crong");
        Cars cars = Cars.from(names);

        // when
        String winners = cars.getWinnerNames();

        // then
        AssertionsForClassTypes.assertThat(winners).contains("pobi");
        AssertionsForClassTypes.assertThat(winners).contains("crong");
    }

}
