package baseball;

import baseball.domain.factory.BaseballNumberFactory;
import baseball.domain.factory.NsBaseballNumberFactory;
import baseball.domain.game.BaseballGame;
import baseball.view.BaseballGameView;
import baseball.view.BaseballGameViewWithNsConsole;

public class Application {
    public static void main(String[] args) {
        BaseballGameView view = new BaseballGameViewWithNsConsole();
        BaseballNumberFactory factory = new NsBaseballNumberFactory();
        BaseballGame game = new BaseballGame(view,factory);
        game.start();
    }
}
