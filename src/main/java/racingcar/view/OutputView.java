package racingcar.view;

import java.util.List;
import racingcar.model.Cars;

public class OutputView {

    public void printResults(final List<Cars> raceResults) {
        printStartMessage();

        for (Cars cars : raceResults) {
            printRaceResult(cars);
        }

        printWinners(raceResults.getLast().getWinnerNames());
    }

    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceResult(final Cars cars) {
        List<String> displays = cars.toDisplayStrings();
        for (String display : displays) {
            System.out.println(display);
        }
        System.out.println();
    }

    public void printWinners(final String winnerNames) {
        System.out.println("최종 우승자 : " + winnerNames);
    }
}


