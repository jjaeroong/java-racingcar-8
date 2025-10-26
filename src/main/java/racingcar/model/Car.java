package racingcar.model;


import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final CarName name;
    private final Position position;

    public Car(final String name) {
        this(new CarName(name), Position.initial());
    }

    private Car(final CarName name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move() {
        if (canMove()) {
            return new Car(this.name, this.position.moveForward());
        }
        return this;
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= MOVE_THRESHOLD;
    }


    public String toDisplayString() {
        return name.getValue() + " : " + position.toDisplayBar();
    }

}

