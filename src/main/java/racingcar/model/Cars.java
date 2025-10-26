package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;



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


}