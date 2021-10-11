package racinggame;

import java.util.List;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
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

    /**
     * 선두 차량의 전진 횟수를 체크한다.
     *
     * @param car 선두 여부를 확인할 자동차
     * @param carStatus 자동차의 전진, 정지 여부를 확인할 상태
     */
    public void checkAdvanceCountOfHeadCar(Car car, CarStatus carStatus) {
        if (carStatus.isAdvance() && car.isHead(advanceCountOfHeadCar+1)) {
            advanceCountOfHeadCar++;
        }
    }

    /**
     * 사용자가 입력한 레이싱 횟수를 빌보드에 저장한다.
     *
     * @param racingCountInput 사용자가 입력한 레이싱 횟수
     */
    public boolean storeRacingCount(String racingCountInput) {
        if (!ValidationUtils.validateRacingCount(racingCountInput)) {
            return false;
        }
        racingCount = Integer.parseInt(racingCountInput);

        return true;
    }

    /**
     * 현재 진행상황을 빌보드에 출력한다.
     *
     * @param carList 진행상황에 표기할 자동차 목록
     */
    public void printBillboard(List<Car> carList) {
        racingCarConsoleView.printCurrentRacingStatus(carList);
    }

    /**
     * 빌보드에 최종 승자를 출력한다.
     *
     * @param racingWinners 최종 승자명(여러 자동차일 경우 , 로 구분)
     */
    public void printFianlWinner(String racingWinners) {
        racingCarConsoleView.printFinalWinner(racingWinners);
    }
}
