package racinggame;

import nextstep.utils.Message;

public class Application {
    public static void main(String[] args) {
        Message message = new Message();
        CarRacing carRacing = new CarRacing(message);
    }
}
