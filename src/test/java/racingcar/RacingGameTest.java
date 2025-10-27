package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.RacingGame;

public class RacingGameTest {
    @Test
    @DisplayName("시도 횟수가 0이면 빈 결과를 반환한다")
    void playWithZeroAttempts() {
        // given
        List<String> names = Arrays.asList("pobi", "crong");
        Cars cars = Cars.from(names);
        int tryCount = 0;
        RacingGame game = new RacingGame(cars, tryCount);

        // when
        List<Cars> results = game.play();

        // then
        assertThat(results).isEmpty();
    }

}
