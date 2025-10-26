package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.InputParser;
import racingcar.model.RacingGame;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarNameValidator validator;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.validator = new CarNameValidator();

    }

    public void run() {

        String nameInput = inputView.readCarNames();
        List<String> names = InputParser.parseCarNames(nameInput);
        validator.validate(names);

        Cars cars = Cars.from(names);

        String tryCountInput = inputView.readTryCount();
        int tryCount = InputParser.parseTryCount(tryCountInput);

        RacingGame racingGame = new RacingGame(cars, tryCount);
        List<Cars> raceResults = racingGame.play();


    }

}