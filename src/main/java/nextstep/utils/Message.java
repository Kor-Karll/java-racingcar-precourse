package nextstep.utils;

import racinggame.Car;

public class Message {
    private final String GET_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private final String GET_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private final String DISPLAY_STEP = "-";
    private final String WINNER_PRE_MESSAGE = "최종 우승자는 ";
    private final String WINNER_TAIL_MESSAGE = " 입니다.";

    public void getCarName() {
        System.out.println(this.GET_CAR_NAME);
    }

    public void getTryNumber() {
        System.out.println(this.GET_TRY_NUMBER);
    }

    public void getResult(Car car) {
        String carName = car.getName() + " : ";
        StringBuilder step = new StringBuilder();
        int carStep = car.getStep();

        for (int i = 0; i < carStep ; i++) {
            step.append(DISPLAY_STEP);
        }
        System.out.println(carName + step);
    }

    public void getWinner(String winner) {
        System.out.println(WINNER_PRE_MESSAGE + winner + WINNER_TAIL_MESSAGE);
    }
}
