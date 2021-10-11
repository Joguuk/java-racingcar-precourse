package racinggame;

import nextstep.utils.Console;

import static racinggame.RacingCarConstants.CAR_NAME_SPLIT_DELIMITER;

public class Player {
    RacingCarConsoleView racingCarConsoleView;
    RacingCarBillboard racingCarBillboard;
    Cars cars;

    public Player() {
        racingCarConsoleView = new RacingCarConsoleView();
        racingCarBillboard = new RacingCarBillboard();
        cars = new Cars(racingCarBillboard);
    }

    public void playRacingCar() {
        boolean isGamePlay = true;

        while (isGamePlay) {
            isGamePlay = startGame();
        }
    }

    public boolean startGame(){
        if (inputCarName() && inputRacingCount()) {
            cars.startRacing();
            return false;
        }
        return true;
    }

    private boolean inputRacingCount() {
        racingCarConsoleView.printRacingCountInputGuideMessage();
        String racingCountInput = Console.readLine();

        if (!racingCarBillboard.storeRacingCount(racingCountInput)) {
            racingCarConsoleView.printRacingCountInputInvalidMessage();
            return false;
        }

        return true;
    }

    private boolean inputCarName() {
        racingCarConsoleView.printCarNameInputGuideMessage();
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(CAR_NAME_SPLIT_DELIMITER);

        return createCars(carNames);
    }

    private boolean createCars(String[] carNames) {
        if (!cars.createCars(carNames)) {
            racingCarConsoleView.printCarNameInputInvalidErrorMessage();
            return false;
        }

        return true;
    }
}
