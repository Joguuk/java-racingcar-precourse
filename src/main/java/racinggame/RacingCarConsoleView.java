package racinggame;

import java.util.List;

import static racinggame.RacingCarConstants.*;

public class RacingCarConsoleView {
    public void printCarNameInputGuideMessage() {
        System.out.println(CAR_NAME_INPUT_GUIDE_MESSAGE);
    }

    public void printRacingCountInputGuideMessage() {
        System.out.println(RACING_COUNT_INPUT_GUIDE_MESSAGE);
    }

    public void printCarNameInputInvalidErrorMessage() {
        System.out.println(CAR_NAME_INPUT_INVALID_ERROR_MESSAGE);
    }

    public void printRacingCountInputInvalidMessage() {
        System.out.println(RACING_COUNT_INPUT_INVALID_MESSAGE);
    }

    public void printCurrentRacingStatus(List<Car> carList) {
        System.out.println("실행 결과");
        for (Car car : carList) {
            System.out.println(car.getCarName() + " : " + getAdvanceMark(car.getAdvanceCount()));
        }
    }

    private String getAdvanceMark(int advanceCount) {
        String advanceMark = "";

        for (int i = 0; i < advanceCount; i++) {
            advanceMark += "-";
        }
        return advanceMark;
    }

    public void printFinalWinner(String racingWinner) {
        System.out.printf(RacingCarConstants.RACING_FINAL_WINNER_GUIDE_MESSAGE, racingWinner);
    }
}
