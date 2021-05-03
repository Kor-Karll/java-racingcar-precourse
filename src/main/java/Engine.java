public class Engine {
    final int MIN_POWER = 3;
    final int MAX_POWER = 9;

    public boolean checkPower() {
        return getRandomPower() > MIN_POWER;
    }

    public int getRandomPower() {
        double random = Math.random();
        return (int)(random * MAX_POWER);
    }
}
