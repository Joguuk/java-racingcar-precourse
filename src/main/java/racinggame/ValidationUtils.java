package racinggame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class ValidationUtils {
    /**
     * 자동차 이름을 유효성 검사한다.
     *
     * @param carName 사용자가 입력한 자동차 이름
     * @return 자동차 이름 정상 여부
     */
    public static boolean validateCarName(String carName) {
        return carName.length() <= RacingCarConstants.MAX_CAR_NAME_LENGTH;
    }

    /**
     * 사용자가 입력한 자동차 이름 목록을 유효성 검사한다.
     *
     * @param carNames 사용자가 입력한 자동차 이름 목록
     * @return 자동차 이름 정상 여부
     */
    public static boolean validateCarNames(String[] carNames) {
        List<Boolean> validCarNames = new ArrayList<>();

        for (String carName : carNames) {
            validCarNames.add(validateCarName(carName));
        }

        return !validCarNames.contains(false);
    }

    /**
     * 사용자가 입력한 자동차 게임 횟수를 유효성 검사한다.
     *
     * @param racingCountInput 사용자가 입력한 자동차 게임 횟수
     * @return 유효성 검사 여부
     */
    public static boolean validateRacingCount(String racingCountInput) {
        if (racingCountInput.chars().allMatch(Character::isDigit)) {
            return true;
        }
        return false;
    }
}
