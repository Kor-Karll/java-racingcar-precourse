package racinggame;

import nextstep.utils.Console;
import nextstep.utils.Message;

import java.util.ArrayList;

public class CarRacing {
    Message message;
    int tryNumber;
    ArrayList<Car> cars;
    int biggestStep = 0;
    final int MAX_CAR_NAME_LENGTH = 5;

    public CarRacing(Message message) {
        this.message = message;
        this.tryNumber = 0;
        this.cars = new ArrayList<>();
    }

    public boolean isRunning() {
        return this.tryNumber != 0;
    }

    public void start() {
        message.getCarName();
        String carNames = getInput();
        createCars(carNames);
        message.getTryNumber();
        this.tryNumber = Integer.parseInt(getInput());

        while (isRunning()) {
            racing();
            this.tryNumber--;
        }
    }

    private void setBiggestStep(Car car) {
        if (checkBiggestStep(car.getStep())) {
            this.biggestStep = car.getStep();
        }
    }

    private boolean checkBiggestStep(int step) {
        return biggestStep <= step;
    }

    private void racing() {
        for (Car car : this.cars) {
            car.runCar();
            message.getResult(car);
            setBiggestStep(car);
        }
    }

    public String getInput() {
        return Console.readLine();
    }

    private void addCar(String carName) {
        if (carName.length() <= this.MAX_CAR_NAME_LENGTH) {
            this.cars.add(new Car(carName));
        }
    }

    private void createCars(String carNames) {
        String[] carName = carNames.split(",");
        for (String s : carName) {
            addCar(s);
        }
    }
}
