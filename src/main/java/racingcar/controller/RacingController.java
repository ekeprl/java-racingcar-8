package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.RacingGame;
import racingcar.util.Util;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void run() {
        Util util = new Util();

        var carNames = InputView.getCarNames();
        var tryCount = InputView.getTryCount();

        var carList = carNames.stream()
                .map(name -> new RacingCar(util, name)) //util에서 난수 생성 처리
                .toList();
        RacingGame racingCars = new RacingGame(carList);

        //시행횟수만큼 실행
        for (int i = 0; i < tryCount; i++) {
            racingCars.moveAll();
            OutputView.printRoundResult(racingCars);
        }

        //결과출력
        OutputView.printWinners(racingCars.findWinners());
    }
}