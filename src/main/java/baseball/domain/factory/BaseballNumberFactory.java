package baseball.domain.factory;

import baseball.domain.data.BaseballNumber;

public interface BaseballNumberFactory {
    int NUMBER_SIZE = 3;

    BaseballNumber createRandomBaseballNumber();

    BaseballNumber createBaseballNumberWithInput(String input);

}
