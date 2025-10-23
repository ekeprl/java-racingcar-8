package racingcar.exception;

public enum ErrorMessage {
    INVALID_OVER_CAR_NAME("차량의 이름은 다섯글자를 초과할 수 없습니다."),
    INVALID_ZERO_CAR_NAME("차량의 이름은 공백이 될 수 없습니다."),
    INVALID_CAR_NAME("차량의 이름은 다섯글자를 초과할 수 없습니다."),

    INVALID_ZERO_ROUND("시행횟수는 0이 될 수 없습니다."),
    INVALID_NUMBER_OF_ROUNDS("0보다 큰 정수를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
