package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    @DisplayName("여러 자동차이름 입력의 실패 케이스를 테스트한다.")
    void 다중_자동차이름_입력_실패() {
        String carNameInput = "sosoa,tete,prir";
        String[] carNames = carNameInput.split(",");
        for (String carName : carNames) {
            boolean isValidName = ValidationUtils.validateCarName(carName);
            assertThat(isValidName).isFalse();
        }
    }

    @Test
    @DisplayName("여러 자동차이름 입력의 성공 케이스를 테스트한다.")
    void 다중_자동차이름_입력_성공() {
        String carNameInput = "soso,tete,prir,prir";
        String[] carNames = carNameInput.split(",");
        boolean isValidName = ValidationUtils.validateCarNames(carNames);
        assertThat(isValidName).isTrue();
    }

    @Test
    @DisplayName("자동차 이름의 글자수 제한 성공 케이스를 테스트한다.")
    void 자동차_이름_5자_제한_성공() {
        String carName = "soso";
        boolean isValidName = ValidationUtils.validateCarName(carName);
        assertThat(isValidName).isTrue();
    }

    @Test
    @DisplayName("자동차 이름의 글자수 제한 실패 케이스를 테스트한다.")
    void 자동차_이름_5자_제한_실패() {
        String carName = "sorento";
        boolean isValidName = ValidationUtils.validateCarName(carName);
        assertThat(isValidName).isFalse();
    }

    @Test
    @DisplayName("주어진 이름으로 자동차 생성을 테스트한다.")
    void 자동차_이름_입력() {
        String carName = "casr";
        Car car = new Car(carName);
        assertThat(car.getCarName()).isEqualTo(carName);
    }
}
