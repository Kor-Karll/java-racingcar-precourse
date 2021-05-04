import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {
    final int MAX_CAR_NAME_LENGTH = 5;
    ArrayList<Car> cars = new ArrayList<>();

    @Test
    void createCars() {
        String carNames = "aaaaa,bbb,cccccc";
        String[] carName = carNames.split(",");
        for (int i = 0; i < carName.length ; i++) {
            addCar(carName[i]);
        }

        assertThat(this.cars).hasSize(2);

        for (int i = 0; i < this.cars.size() ; i++) {
            Car car = cars.get(i);
            assertThat(car.getName().length() > 5).isFalse();
        }
    }

    private void addCar(String carName) {
        if (carName.length() <= this.MAX_CAR_NAME_LENGTH) {
            this.cars.add(new Car(carName));
        }
    }
}