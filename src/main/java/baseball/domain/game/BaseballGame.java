package baseball.domain.game;

import baseball.domain.data.BaseballHint;
import baseball.domain.data.BaseballNumber;
import baseball.domain.factory.BaseballHintFactory;
import baseball.domain.factory.BaseballNumberFactory;
import baseball.view.BaseballGameView;

public class BaseballGame {
    private BaseballGameView view;
    private BaseballNumberFactory baseballNumberFactory;
    private BaseballHintFactory baseballHintFactory;
    private boolean isEnd = false;

    public BaseballGame(BaseballGameView view, BaseballNumberFactory baseballNumberFactory, BaseballHintFactory baseballHintFactory) {
        this.view = view;
        this.baseballNumberFactory = baseballNumberFactory;
        this.baseballHintFactory = baseballHintFactory;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void start(){
        BaseballNumber inputNumber = takeNumberInputs();
        BaseballHint hint = baseballHintFactory.createBaseballHint(inputNumber);
        printHint(hint);
        printNothingCorrect(hint);
        printAnswerCorrect(hint);
        if(isAnswerCorrect(hint)){
            isEnd = true;
        }
    }

    private BaseballNumber takeNumberInputs(){
        String input = view.requestInputNumberMessage();
        return baseballNumberFactory.createBaseballNumberWithInput(input);
    }

    private void printHint(BaseballHint hint){
        if(!isNothingCorrect(hint)){
            view.printHintMessage(hint);
        }
    }

    private void printNothingCorrect(BaseballHint hint){
        if(isNothingCorrect(hint)){
            view.printNotingMessage();
        }
    }

    private boolean isNothingCorrect(BaseballHint hint){
        return hint.getBall() == 0 && hint.getStrike() == 0;
    }

    private void printAnswerCorrect(BaseballHint hint){
        if(isAnswerCorrect(hint)){
            view.printAnswerCorrectMessage();
        }
    }

    public boolean isAnswerCorrect(BaseballHint hint){
        return hint.getStrike() == BaseballNumberFactory.NUMBER_SIZE;
    }
}
