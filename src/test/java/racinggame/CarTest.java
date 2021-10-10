package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        String carName = "soso";
        car = new Car(carName);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 정지_조건(int randomNumber) {
        CarStatus carStatus = car.move(randomNumber);
        assertThat(carStatus).isEqualTo(CarStatus.STOP);
        assertThat(car.getAdvanceCount()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void 전진_조건(int randomNumber) {
        CarStatus carStatus = car.move(randomNumber);
        assertThat(carStatus).isEqualTo(CarStatus.ADVANCE);
        assertThat(car.getAdvanceCount()).isEqualTo(1);
    }
}
