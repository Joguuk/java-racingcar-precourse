package racinggame;

import java.util.List;

public class RacingCarBillboard {
    private int advanceCountOfHeadCar;  // 선두차의 전진 횟수

    public void report(Car car, CarStatus carStatus) {
        if (carStatus.isAdvance() && car.isHead(advanceCountOfHeadCar+1)) {
            advanceCountOfHeadCar++;
        }
    }

    public void printBillboard(List<Car> carList) {
        RacingCarConsoleView racingCarConsoleView = new RacingCarConsoleView();
        racingCarConsoleView.printCurrentRacingStatus(carList);
    }

    public String getRacingWinner(Cars cars) {
        System.out.println("advanceCountOfHeadCar = " + advanceCountOfHeadCar);
        return cars.getRacingWinner(advanceCountOfHeadCar);
    }
}
