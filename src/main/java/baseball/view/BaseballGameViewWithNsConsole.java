package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameViewWithNsConsole implements BaseballGameView{
    @Override
    public String requestInputNumberMessage() {
        System.out.print("숫자를 입력하세요: ");
        return Console.readLine();
    }
}
