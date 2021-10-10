package racinggame;

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

    public CarStatus move(int moveRandomNumber) {
        if (moveRandomNumber >= 4) {
            this.advanceCount += 1;
            return CarStatus.ADVANCE;
        }

        return CarStatus.STOP;
    }

    public boolean isHead(int advanceCountOfHeadCar) {
        return this.advanceCount == advanceCountOfHeadCar;
    }
}
