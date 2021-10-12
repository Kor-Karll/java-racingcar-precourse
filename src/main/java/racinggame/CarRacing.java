package racinggame;

import nextstep.utils.Message;

public class CarRacing {
    Message message;
    int tryNumber;

    public CarRacing(Message message) {
        this.message = message;
        this.tryNumber = 0;
    }

    public boolean isRunning() {
        return this.tryNumber == 0;
    }

    public void start() {
        message.getCarName();
    }
}
