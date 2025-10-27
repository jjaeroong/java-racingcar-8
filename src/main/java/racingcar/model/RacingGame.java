package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.error.ErrorMessage;

public class RacingGame {
    private final Cars cars;
    private final int numberOfAttempts;

    public RacingGame(Cars cars, int numberOfAttempts) {
        validateNumberOfAttempts(numberOfAttempts);
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<Cars> play() {
        List<Cars> raceResults = new ArrayList<>();
        Cars currentCars = this.cars;

        for (int i = 0; i < numberOfAttempts; i++) {
            currentCars = currentCars.moveAll();
            raceResults.add(currentCars);
        }
        return raceResults;
    }
    private void validateNumberOfAttempts(final int numberOfAttempts) {
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.message());
        }
    }
}