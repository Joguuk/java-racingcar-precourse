package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;
    RacingCarConsoleView racingCarConsoleView;

    @BeforeEach
    void setUp() {
        String carsNameInput = new String("caer,soso,qoo");
        cars = new Cars();
        cars.createCars(carsNameInput.split(","));

        racingCarConsoleView = new RacingCarConsoleView();
    }

    @Test
    @DisplayName("n개의 자동차를 3번 전진시키는 기능을 테스트한다.")
    void 여러_자동차_3회_게임_실행() {
        RacingCarBillboard racingCarBillboard = null;
        List<Integer> randomNumberList = null;

        for (int i = 0; i < 3; i++) {
            randomNumberList = Arrays.asList(i+1, i+2, i+3);
        }
        racingCarBillboard = cars.moves(3, randomNumberList);

        String racingWinner = racingCarBillboard.getRacingWinner(cars);
        System.out.println("racingWinner = " + racingWinner);
        assertThat(racingWinner).contains("soso,qoo");
    }

    @Test
    @DisplayName("n개의 자동차를 1번 전진시키는 기능을 테스트한다.")
    void 여러_자동차_1회_게임_실행() {
        RacingCarBillboard racingCarBillboard = cars.move(Arrays.asList(4, 5, 6));
        String racingWinner = racingCarBillboard.getRacingWinner(cars);
        assertThat(racingWinner).contains("caer,soso,qoo");
    }
}