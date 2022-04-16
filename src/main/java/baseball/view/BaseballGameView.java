package baseball.view;

import baseball.domain.data.BaseballHint;

public interface BaseballGameView {
    String requestInputNumberMessage();
    void printHintMessage(BaseballHint hint);
    void printAnswerCorrectMessage();
    void printNotingMessage();
}
