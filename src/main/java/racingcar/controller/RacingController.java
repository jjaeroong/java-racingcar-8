package racingcar.controller;

import java.util.List;
import racingcar.model.InputParser;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;


    public RacingController() {
        this.inputView = new InputView();

    }

    public void run() {

        String nameInput = inputView.readCarNames();
        List<String> names = InputParser.parseCarNames(nameInput);

    }

}