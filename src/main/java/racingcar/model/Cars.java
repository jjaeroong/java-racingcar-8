package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.error.ErrorMessage;

public class Cars {
    private final List<Car> cars;
    private static final String DELIMITER = ", ";


    private Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars from(final List<String> names) {
        List<Car> carList = names.stream()
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }


    public Cars moveAll() {
        return new Cars(cars.stream()
                .map(Car::move)
                .toList());
    }

    public List<String> toDisplayStrings() {
        return cars.stream()
                .map(Car::toDisplayString)
                .toList();
    }

    public String getWinnerNames() {
        Car winner = findWinnerCar();
        return cars.stream()
                .filter(car -> car.hasSamePositionAs(winner))
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }
    private Car findWinnerCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.NO_PARTICIPANTS.message()));
    }
}