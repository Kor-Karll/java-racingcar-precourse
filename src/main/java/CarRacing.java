import java.util.ArrayList;
import java.util.Scanner;

public class CarRacing {
    Message message;
    int tryNumber;
    ArrayList<Car> cars;
    int biggestStep = 0;
    String winner;
    final int MAX_CAR_NAME_LENGTH = 5;
    final String DISPLAY_STEP = "-";

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
        System.out.println(this.winner + "가 최종 우승했습니다.");
    }

    private void setBiggestStep(String carName, int step) {
        this.biggestStep = step;
        if (this.winner.length() != 0) {
            this.winner += ", ";
        }
        this.winner += carName;
    }

    private boolean checkBiggestStep(int step) {
        return biggestStep <= step;
    }

    private void printResult(Car car) {
        String carName = car.getName();
        String step = "";
        int carStep = car.getStep();

        if(checkBiggestStep(carStep)) {
            setBiggestStep(carName, carStep);
        }

        for (int i = 0; i < carStep ; i++) {
            step += DISPLAY_STEP;
        }
        System.out.println(carName + " : " + step);
    }

    private void racing() {
        winner = "";
        for (int i = 0; i < this.cars.size() ; i++) {
            Car car = cars.get(i);
            car.runCar();
            printResult(car);
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
