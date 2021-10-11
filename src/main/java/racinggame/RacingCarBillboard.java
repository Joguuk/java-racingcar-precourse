package racinggame;

import java.util.List;

public class RacingCarBillboard {
    private RacingCarConsoleView racingCarConsoleView;
    private int advanceCountOfHeadCar;  // 선두차의 전진 횟수
    private int racingCount;

    public RacingCarBillboard() {
        this.racingCarConsoleView = new RacingCarConsoleView();
        this.advanceCountOfHeadCar = 0;
    }

    public int getRacingCount() {
        return racingCount;
    }

    public int getAdvanceCountOfHeadCar() {
        return advanceCountOfHeadCar;
    }

    public void report(Car car, CarStatus carStatus) {
        if (carStatus.isAdvance() && car.isHead(advanceCountOfHeadCar+1)) {
            advanceCountOfHeadCar++;
        }
    }

    public boolean storeRacingCount(String racingCountInput) {
        if (!ValidationUtils.validateRacingCount(racingCountInput)) {
            return false;
        }
        racingCount = Integer.parseInt(racingCountInput);

        return true;
    }

    public void printBillboard(List<Car> carList) {
        racingCarConsoleView.printCurrentRacingStatus(carList);
    }

    public void printFianlWinner(String racingWinner) {
        racingCarConsoleView.printFinalWinner(racingWinner);
    }
}
