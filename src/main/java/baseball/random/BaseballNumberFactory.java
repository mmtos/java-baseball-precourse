package baseball.random;

import baseball.data.BaseballNumber;

public interface BaseballNumberFactory {
    int NUMBER_SIZE = 3;
    BaseballNumber createRandomBaseballNumber();
}
