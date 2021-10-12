package racinggame;

import nextstep.utils.Console;
import nextstep.utils.Message;

import java.util.ArrayList;

public class CarRacing {
    Message message;
    int tryNumber;
    ArrayList<Car> cars;

    public CarRacing(Message message) {
        this.message = message;
        this.tryNumber = 0;
        this.cars = new ArrayList<>();
    }

    public boolean isRunning() {
        return this.tryNumber == 0;
    }

    public void start() {
        message.getCarName();
        String carNames = getInput();
        createCars(carNames);
        message.getTryNumber();
        this.tryNumber = Integer.parseInt(getInput());
    }

    public String getInput() {
        return Console.readLine();
    }

    private void createCars(String carNames) {
        String[] carName = carNames.split(",");
        for (String s : carName) {
            this.cars.add(new Car(s));
        }
    }
}
