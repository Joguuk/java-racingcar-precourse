package racinggame;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Car {
    private final String carName;
    private int advanceCount;

    public Car(String carName) {
        this.carName = carName;
        this.advanceCount = 0;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public String getCarName() {
        return carName;
    }

    /**
     * 입력 받은 랜덤 숫자를 판단하여 전진 혹은 정지한다.
     *
     * @param moveRandomNumber 전진 여부를 판단한 랜덤 숫자
     * @return 자동차의 전진/정지 상태
     */
    public CarStatus move(int moveRandomNumber) {
        if (moveRandomNumber >= RacingCarConstants.ADVANCE_BASE_NUM){
            this.advanceCount += 1;
            return CarStatus.ADVANCE;
        }

        return CarStatus.STOP;
    }

    /**
     * 선두 차량의 전진 횟수와 비교하여 자신이 선두 차량인지 반환한다.
     *
     * @param advanceCountOfHeadCar 선두 차량의 전진 횟수
     * @return 선두 차량 여부
     */
    public boolean isHead(int advanceCountOfHeadCar) {
        return this.advanceCount == advanceCountOfHeadCar;
    }
}
