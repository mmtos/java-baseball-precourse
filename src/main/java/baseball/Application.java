package baseball;

import baseball.domain.factory.BaseballHintFactory;
import baseball.domain.factory.BaseballNumberFactory;
import baseball.domain.factory.NsBaseballNumberFactory;
import baseball.domain.game.BaseballGame;
import baseball.view.BaseballGameView;
import baseball.view.BaseballGameViewWithNsConsole;

public class Application {
    public static void main(String[] args) {
        BaseballGameView view = new BaseballGameViewWithNsConsole();
        BaseballNumberFactory numberFactory = new NsBaseballNumberFactory();
        BaseballGame game = null;
        do{
            BaseballHintFactory hintFactory = new BaseballHintFactory(numberFactory.createRandomBaseballNumber());
            game = new BaseballGame(view, numberFactory, hintFactory);
            game.start();
        }while (!game.isGameOver());
    }
}
