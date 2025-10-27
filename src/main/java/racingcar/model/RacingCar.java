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


    /** 현재 이름 반환 */
    public String getName() {
        return name;
    }

    /** 현재 위치 반환 */
    public int getPosition() {
        return position;
    }

    /** 현재 자동차의 상태(이름 + 위치)를 문자열로 반환 (디버깅용) */
    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

}
