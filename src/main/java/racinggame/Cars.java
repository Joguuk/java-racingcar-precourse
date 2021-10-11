package racinggame;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Cars {
    private final List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    /**
     * 입력받은 자동차 이름 목록 만큼 자동차를 생성한다.
     *
     * @param carNames 사용자가 입력한 자동차 이름 목록
     * @return 자동차 정상 생성 여부
     */
    public boolean createCars(String[] carNames) {
        if (!ValidationUtils.validateCarNames(carNames)) {
            return false;
        }

        for (int i = 0; i < carNames.length; i++) {
            this.carList.add(new Car(carNames[i]));
        }
        return true;
    }

    /**
     * 빌보드에 입력된 레이싱 횟수 만큼 레이싱 게임을 시작한다.
     */
    public void startRacing(int racingCount) {
        moves(racingCount);
    }

    /**
     * 레이싱 횟수 만큼 반복하여 게임을 진행한다.
     * 매 반복 마다 진행상황을 출력한다.
     *
     * @param racingCount 레이싱 횟수
     */
    public void moves(int racingCount) {
        RacingCarConsoleView racingCarConsoleView = RacingCarConsoleView.getInstance();

        for (int i = 0; i < racingCount; i++) {
            List<Integer> randomNumberList = generateRandomNumberList();
            move(randomNumberList);
            racingCarConsoleView.printCurrentRacingStatus(carList);
        }
    }

    /**
     * 입력 받은 랜덤 숫자 목록을 기준으로 자동차들을 전진시킨다.
     * 자동차들이 전진할 때마다 선두 차량의 전진 횟수를 확인한다.
     *
     * @param randomNumbers 랜덤 숫자 목록
     */
    public void move(List<Integer> randomNumbers) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            CarStatus carStatus = car.move(randomNumbers.get(i));
        }
    }

    /**
     * 게임에 참여한 자동차 수 만큼 랜던 숫자 목록을 생성한다.
     *
     * @return 랜던 숫자 목록
     */
    private List<Integer> generateRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            randomNumberList.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNumberList;
    }

    /**
     * 레이싱 게임의 승자 자동차 이름을 반환한다.
     *
     * @return 레이싱 게임 승자 자동차 이름(자동차 이름이 여러 개일 경우 , 로 구분)
     */
    public String getRacingWinners() {
        String racingWinners = "";

        for (Car car : carList) {
            racingWinners += getLeadCarNames(car, racingWinners);
        }

        return racingWinners;
    }

    /**
     * 선두차의 전진 횟수를 반환한다.
     *
     * @return 선두 차량의 전진 횟수
     */
    private int getAdvanceCountOfLeadCar() {
        int advanceCountOfLeadCar = 0;
        for (Car car : carList) {
            advanceCountOfLeadCar = car.getAdvanceCount() > advanceCountOfLeadCar ? car.getAdvanceCount() : advanceCountOfLeadCar;
        }
        return advanceCountOfLeadCar;
    }

    /**
     * 자동차의 선두 여부를 확인하여 선두인 경우 자동차 이름을 반환한다.
     *
     * @param car 승자 여부를 판단할 자동차
     * @param racingWinners 현재 입력된 승자 자동차 이름
     * @return 선두 자동차 이름(자동차 이름이 여러 개일 경우 , 로 구분)
     */
    private String getLeadCarNames(Car car, String racingWinners) {
        boolean isLead = car.isLead(getAdvanceCountOfLeadCar());

        if (isLead && racingWinners.isEmpty()){
            return car.getCarName();
        }

        return isLead ?  "," +car.getCarName() : "";
    }
}
