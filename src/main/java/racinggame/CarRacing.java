package racinggame;

import nextstep.utils.Console;
import nextstep.utils.Message;

import java.util.ArrayList;

public class CarRacing {
    Message message;
    int tryNumber;
    ArrayList<Car> cars;
    int biggestStep = 0;
    String winner = "";
    final int MAX_CAR_NAME_LENGTH = 5;
    boolean error = false;

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
        if (this.error) {
            message.getErrorMessage();
        }
        message.getTryNumber();
        this.tryNumber = Integer.parseInt(getInput());

        while (isRunning()) {
            racing();
            this.tryNumber--;
        }
        this.getWinner();
        message.getWinner(this.winner);
    }

    private void setBiggestStep(Car car) {
        if (checkBiggestStep(car.getStep())) {
            this.biggestStep = car.getStep();
        }
    }

    private void getWinner() {
        for (Car car : this.cars) {
            setWinnerComma();
            setWinner(car);
        }
    }

    private void setWinnerComma() {

    }

    private void setWinner(Car car) {
        if (this.checkBiggestStep(car.getStep()) && this.winner.length() > 0) {
            this.winner += ", ";
        }

        if (this.checkBiggestStep(car.getStep())) {
            this.winner += car.getName();
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
            return;
        }

        this.error = true;
    }

    private void createCars(String carNames) {
        String[] carName = carNames.split(",");
        for (String s : carName) {
            addCar(s);
        }
    }
}
