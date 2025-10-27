package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    /** 한 라운드 자동차 상태 출력 */
    public static void printRoundResult(RacingGame racingGame) {
        for (RacingCar car : racingGame.getCars()) {
            System.out.println(car); // RacingCar.toString() 사용
        }
        System.out.println(); // 라운드 구분용 공백
    }

    /** 최종 우승자 출력 */
    public static void printWinners(List<RacingCar> winners) {
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자: " + winnerNames);
    }
}
