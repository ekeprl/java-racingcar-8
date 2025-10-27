package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<RacingCar> racingCars; // 여러 자동차 객체 관리

    public RacingGame(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            throw new IllegalArgumentException("자동차 리스트는 비어 있을 수 없습니다.");
        }
        this.racingCars = racingCars;
    }

    public void moveAll() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
        }
    }

    public int findMaxPosition() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }

    //라운드 우승자
    public List<RacingCar> findWinners() {
        int maxPosition = findMaxPosition();
        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<RacingCar> getCars() {
        return racingCars;
    }
}
