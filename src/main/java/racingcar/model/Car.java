package racingcar.model;


public class Car{

    private final CarName name;
    private final Position position;

    public Car(final String name) {
        this(new CarName(name), Position.initial());
    }

    private Car(final CarName name, final Position position) {
        this.name = name;
        this.position = position;
    }

}
