package baseball.domain.factory;

import baseball.domain.data.BaseballHint;
import baseball.domain.data.BaseballNumber;
import java.util.List;

public class BaseballHintFactory {
    private BaseballNumber answer;

    public BaseballHintFactory(BaseballNumber answer) {
        this.answer = answer;
    }

    public BaseballHint createBaseballHint(BaseballNumber input) {
        int containCount = calculateContainCount(input);
        int samePositionCount = calculateSamePositionCount(input);
        int strike = samePositionCount;
        int ball = containCount - samePositionCount;
        return new BaseballHint(strike, ball);
    }

    private int calculateContainCount(BaseballNumber input) {
        List<Integer> inputNumbers = input.getNumbers();
        int containCount = 0;
        for (int inputNumber : inputNumbers) {
            containCount += isAnswerContainNumber(inputNumber);
        }
        return containCount;
    }

    private int isAnswerContainNumber(int inputNumber) {
        List<Integer> answerNumbers = answer.getNumbers();
        if (answerNumbers.contains(inputNumber)) {
            return 1;
        }
        return 0;
    }

    private int calculateSamePositionCount(BaseballNumber input) {
        List<Integer> answerNumbers = answer.getNumbers();
        List<Integer> inputNumbers = input.getNumbers();
        int samePositionCount = 0;
        for (int i = 0; i < BaseballNumberFactory.NUMBER_SIZE; i++) {
            samePositionCount += isSameNumber(answerNumbers.get(i), inputNumbers.get(i));
        }
        return samePositionCount;
    }

    private int isSameNumber(int number1, int number2) {
        if (number1 == number2) {
            return 1;
        }
        return 0;
    }
}
