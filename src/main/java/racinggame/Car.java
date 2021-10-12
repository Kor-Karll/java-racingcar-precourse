package racinggame;

public class Car {
    private String name;
    private int step;
    Engine engine;

    public Car(String name) {
        this.name = name;
        this.step = 0;
        this.engine = new Engine();
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void increaseStep() {
        this.step++;
    }

    public void runCar() {
        if(engine.checkPower()) {
            increaseStep();
        }
    }
}
