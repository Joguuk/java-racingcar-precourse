package racinggame;

import java.util.List;

import static racinggame.RacingCarConstants.*;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class RacingCarConsoleView {
    /**
     * 자동차 이름 입력 안내 문구를 출력한다.
     */
    public void printCarNameInputGuideMessage() {
        System.out.println(CAR_NAME_INPUT_GUIDE_MESSAGE);
    }

    /**
     * 레이싱 횟수 입력 안내 문구를 출력한다.
     */
    public void printRacingCountInputGuideMessage() {
        System.out.println(RACING_COUNT_INPUT_GUIDE_MESSAGE);
    }

    /**
     * 자동차 이름 입력 에러 문구를 출력한다.
     */
    public void printCarNameInputInvalidErrorMessage() {
        System.out.println(CAR_NAME_INPUT_INVALID_ERROR_MESSAGE);
    }

    /**
     * 레이싱 횟수 입력 에러 문구를 출력한다.
     */
    public void printRacingCountInputInvalidMessage() {
        System.out.println(RACING_COUNT_INPUT_INVALID_MESSAGE);
    }

    /**
     * 현재 레이싱 진행 상황을 출력한다.
     *
     * @param carList 진행 상황을 출력할 자동차 목록
     */
    public void printCurrentRacingStatus(List<Car> carList) {
        System.out.println(RacingCarConstants.CURRENT_STATUS_GUIDE_MESSAGE_ON_BILLBOARD);
        for (Car car : carList) {
            System.out.println(car.getCarName() + " : " + getAdvanceMark(car.getAdvanceCount()));
        }
    }

    /**
     * 현재 레이싱 게임 진행 상황에 출력할 전진 기호를 반환한다.
     *
     * @param advanceCount 전진 횟수
     * @return 전진 기호
     */
    private String getAdvanceMark(int advanceCount) {
        String advanceMark = "";

        for (int i = 0; i < advanceCount; i++) {
            advanceMark += "-";
        }
        return advanceMark;
    }

    /**
     * 레이싱 게임 최종 승자를 출력한다.
     *
     * @param racingWinners 최송 승자(여러 자동차일 경우 , 로 구분)
     */
    public void printFinalWinner(String racingWinners) {
        System.out.printf(RacingCarConstants.RACING_FINAL_WINNER_GUIDE_MESSAGE, racingWinners);
    }
}
