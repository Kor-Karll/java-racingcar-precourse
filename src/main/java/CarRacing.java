import java.util.ArrayList;
import java.util.Scanner;

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
    }

    private String getInput() {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        return input;
    }

    private void createCars(String carNames) {
        String[] carName = carNames.split(",");
        for (int i = 0; i < carName.length ; i++) {
            this.cars.add(new Car(carName[i]));
        }
    }
}
