package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;


public class InputView {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();

        validateInput(input);
        splitInput(input);

        return  splitInput(input);

    }

    //글자 수 체크
    private static void wordCountCheck(List<String> obj) {
        for (String names : obj) {
            if (names.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_OVER_CAR_NAME.getMessage());
            }
        }
    }

    //입력값 split
    private static List<String> splitInput(String obj) {

        List<String> carNames = Arrays.stream(obj.split(","))
                .map(String::trim)
                .toList();

        wordCountCheck(carNames);
        return carNames;
    }

    //입력값 검증
    private static void validateInput(String obj) {
        if(obj == null || obj.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ZERO_CAR_NAME.getMessage());
        }
    }



    //시행횟수 block
    //입력값 검증
    private static void inputCountCheck(int obj) {
        if(obj <= 0 ) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_ROUNDS.getMessage());
        }
    }

    //입력값 검증
    private static int validateCountInput(String obj) {
        if(obj == null || obj.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ZERO_ROUND.getMessage());
        }
        int count = Integer.parseInt(obj);
        inputCountCheck(count);
        return count;

    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        return validateCountInput(input);
    }

}
