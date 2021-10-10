package racinggame;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtils {
    public static boolean validateCarName(String carName) {
        return carName.length() < RacingCarConstants.MAX_CAR_NAME_LENGTH;
    }

    public static boolean validateCarNames(String[] carNames) {
        List<Boolean> validCarNames = new ArrayList<>();

        for (String carName : carNames) {
            validCarNames.add(validateCarName(carName));
        }

        return !validCarNames.contains(false);
    }
}
