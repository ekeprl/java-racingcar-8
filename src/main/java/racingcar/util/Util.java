package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {

    //난수생성 Util에서 처리하도록
    public int randomNumberGenerate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
