package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Position;

class PositionTest {

    @Test
    @DisplayName("초기 위치는 0이다")
    void createInitialPosition() {

        Position position = Position.initial();

        assertThat(position.toDisplayBar()).isEmpty();
    }

    @Test
    @DisplayName("위치를 전진시킬 수 있다")
    void moveForward() {

        Position position = Position.initial();

        Position movedPosition = position.moveForward();

        assertThat(movedPosition.toDisplayBar()).isEqualTo("-");
    }

    @Test
    @DisplayName("음수 위치는 생성할 수 없다")
    void createPositionWithNegativeValue() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 위치인지 비교할 수 있다")
    void comparePositions() {

        Position position1 = new Position(3);
        Position position2 = new Position(3);
        Position position3 = new Position(2);

        assertThat(position1.isSameAs(position2)).isTrue();
        assertThat(position1.isSameAs(position3)).isFalse();
    }

    @Test
    @DisplayName("위치를 비교할 수 있다")
    void compareToPosition() {

        Position smaller = new Position(2);
        Position bigger = new Position(5);

        assertThat(smaller.compareTo(bigger)).isNegative();
        assertThat(bigger.compareTo(smaller)).isPositive();
        assertThat(smaller.compareTo(new Position(2))).isZero();
    }
}
