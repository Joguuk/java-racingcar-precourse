package racinggame;

import nextstep.utils.Console;

import static racinggame.RacingCarConstants.CAR_NAME_SPLIT_DELIMITER;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Player {
    private RacingCarConsoleView racingCarConsoleView;
    private RacingCarBillboard racingCarBillboard;
    private Cars cars;

    public Player() {
        racingCarConsoleView = new RacingCarConsoleView();
        racingCarBillboard = new RacingCarBillboard();
        cars = new Cars(racingCarBillboard);
    }

    /**
     * 레이싱 게임을 시작한다.
     * 사용자가 게임을 시작하기에 올바르지 않은 값을 입력한 경우 계속해서 재입력 받는다.
     */
    public void launchRacingCar() {
        boolean isGamePlay = true;

        while (isGamePlay) {
            isGamePlay = playGame();
        }
    }

    /**
     * 게임에 참여하기 위해 사용자의 입력을 받고 올바른 입력인 경우 게임을 시작한다.
     *
     * @return 게임 정상 종료 여부
     */
    public boolean playGame(){
        if (inputCarName() && inputRacingCount()) {
            cars.startRacing();
            return false;
        }
        return true;
    }

    /**
     * 사용자에게 레이싱 게임을 몇 번 수행할지를 입력 받는다.
     * 올바르지 않은 값이 입력된 경우 에러 메세지를 출력한다.
     *
     * @return 정상입력 여부
     */
    private boolean inputRacingCount() {
        racingCarConsoleView.printRacingCountInputGuideMessage();
        String racingCountInput = Console.readLine();

        if (!racingCarBillboard.storeRacingCount(racingCountInput)) {
            racingCarConsoleView.printRacingCountInputInvalidMessage();
            return false;
        }

        return true;
    }

    /**
     * 사용자에게 게임에 참여할 자동차 이름을 입력받는다.
     *
     * @return 정상입력 여부
     */
    private boolean inputCarName() {
        racingCarConsoleView.printCarNameInputGuideMessage();
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(CAR_NAME_SPLIT_DELIMITER);

        return createCars(carNames);
    }

    /**
     * 사용자가 입력한 자동차 이름으로 자동차를 생성한다.
     * 자동차가 정상적으로 생성되지 않은 경우 에러 메세지를 출력한다.
     *
     * @param carNames 사용자가 입력한 자동차 이름 목록(, 를 기준으로 구분한다.)
     * @return 게임에 참여할 자동차의 정상 생성 여부
     */
    private boolean createCars(String[] carNames) {
        if (!cars.createCars(carNames)) {
            racingCarConsoleView.printCarNameInputInvalidErrorMessage();
            return false;
        }

        return true;
    }
}
