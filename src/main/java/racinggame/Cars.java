package racinggame;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;
    private final RacingCarBillboard racingCarBillboard;

    public Cars(RacingCarBillboard racingCarBillboard) {
        this.carList = new ArrayList<>();
        this.racingCarBillboard = racingCarBillboard;
    }

    public boolean createCars(String[] carNames) {
        if (!ValidationUtils.validateCarNames(carNames)) {
            return false;
        }

        for (int i = 0; i < carNames.length; i++) {
            this.carList.add(new Car(carNames[i]));
        }
        return true;
    }

    public void startRacing() {
        moves(racingCarBillboard.getRacingCount());

        racingCarBillboard.printFianlWinner(getRacingWinner());
    }

    public RacingCarBillboard moves(int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            List<Integer> randomNumberList = generateRandomNumberList();
            move(randomNumberList);
            racingCarBillboard.printBillboard(carList);
        }

        return racingCarBillboard;
    }

    public void move(List<Integer> moveRandomNumbers) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            CarStatus carStatus = car.move(moveRandomNumbers.get(i));
            racingCarBillboard.report(car, carStatus);
        }
    }

    private List<Integer> generateRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            randomNumberList.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNumberList;
    }

    public String getRacingWinner() {
        String racingWinners = "";

        for (Car car : carList) {
            racingWinners += getHeadCarNames(car, racingWinners);
        }

        return racingWinners;
    }

    private String getHeadCarNames(Car car, String racingWinners) {
        boolean isHead = car.isHead(racingCarBillboard.getAdvanceCountOfHeadCar());

        if (isHead && racingWinners.isEmpty()){
            return car.getCarName();
        }

        return isHead ?  "," +car.getCarName() : "";
    }
}
