package racinggame;

import nextstep.utils.Randoms;

public class Engine {
    final int MIN_POWER = 3;
    final int MAX_POWER = 9;

    public boolean checkPower() {
        return getRandomPower() > MIN_POWER;
    }

    public int getRandomPower() {
        return Randoms.pickNumberInRange(0, MAX_POWER);
    }
}