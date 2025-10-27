package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.RacingGame;

public class RacingGameTest {

    @Test
    @DisplayName("시도 횟수가 0이면 예외가 발생한다")
    void playWithZeroAttempts() {

        List<String> names = Arrays.asList("pobi", "crong");
        Cars cars = Cars.from(names);
        int tryCount = 0;


        assertThatThrownBy(() -> new RacingGame(cars, tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("시도 횟수가 음수이면 예외가 발생한다")
    void playWithNegativeAttempts() {

        List<String> names = Arrays.asList("pobi", "crong");
        Cars cars = Cars.from(names);
        int tryCount = -1;


        assertThatThrownBy(() -> new RacingGame(cars, tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공동 우승자가 여러 명일 때 쉼표로 구분하여 반환한다")
    void getMultipleWinnerNames() {

        List<String> names = Arrays.asList("pobi", "crong", "jjae");
        Cars cars = Cars.from(names);

        String winners = cars.getWinnerNames();


        assertThat(winners).contains("pobi", "crong", "jjae");
    }
}
