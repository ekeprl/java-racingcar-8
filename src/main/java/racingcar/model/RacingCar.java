package racingcar.model;

import racingcar.exception.ErrorMessage;
import racingcar.util.Util;

public class RacingCar {

    private final Util util; // 난수 생성기 주입

    private final int move_standard = 4;
    private String name;
    private int position = 0;

    public RacingCar(Util util, String name) {
        this.util = util;
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ZERO_CAR_NAME.getMessage());
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OVER_CAR_NAME.getMessage());
        }
    }

    public void move() {
        int randomNumber = util.randomNumberGenerate();
        if (randomNumber >= move_standard) {
            position++;
        }
    }


    public String getName() {
        return name;
    }


    public int getPosition() {
        return position;
    }

    // 결과 확인
    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

}
