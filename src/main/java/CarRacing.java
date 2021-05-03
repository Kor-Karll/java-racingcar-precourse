import java.util.ArrayList;
import java.util.Scanner;

public class CarRacing {
    Message message;
    int tryNumber;
    ArrayList<Car> cars;
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
            this.tryNumber--;
        }
    }

    private String getInput() {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        return input;
    }

    private void addCar(String carName) {
        if (carName.length() <= this.MAX_CAR_NAME_LENGTH) {
            this.cars.add(new Car(carName));
        }
    }

    private void createCars(String carNames) {
        String[] carName = carNames.split(",");
        for (int i = 0; i < carName.length ; i++) {
            addCar(carName[i]);
        }
    }
}
