package baseball.domain.game;

import baseball.domain.data.BaseballNumber;
import baseball.domain.factory.BaseballNumberFactory;
import baseball.view.BaseballGameView;

public class BaseballGame {
    private BaseballGameView view;
    private BaseballNumberFactory baseballNumberFactory;

    public BaseballGame(BaseballGameView view, BaseballNumberFactory baseballNumberFactory) {
        this.view = view;
        this.baseballNumberFactory = baseballNumberFactory;
    }

    public void start(){
        BaseballNumber inputNumber = takeNumberInputs();
        System.out.println(inputNumber);
    }

    private BaseballNumber takeNumberInputs(){
        String input = view.requestInputNumberMessage();
        return baseballNumberFactory.createBaseballNumberWithInput(input);
    }

}
