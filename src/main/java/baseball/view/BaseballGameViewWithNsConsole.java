package baseball.view;

import baseball.domain.data.BaseballHint;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameViewWithNsConsole implements BaseballGameView{
    @Override
    public String requestInputNumberMessage() {
        System.out.print("숫자를 입력하세요: ");
        return Console.readLine();
    }

    @Override
    public void printHintMessage(BaseballHint hint) {
        String ballMessage = makeBallMessage(hint.getBall());
        String strikeMessage = makeStrikeMessage(hint.getStrike());
        System.out.println(makeFullMessage(ballMessage,strikeMessage));
    }

    private String makeBallMessage(int ball){
        if(ball == 0){
            return "";
        }
        return ball+"볼";
    }

    private String makeStrikeMessage(int strike){
        if(strike == 0){
            return "";
        }
        return strike+"스트라이크";
    }

    private String makeFullMessage(String ballMessage, String strikeMessage){
        if(!"".equals(ballMessage)) strikeMessage = " "+ strikeMessage;
        return ballMessage + strikeMessage;
    }

    @Override
    public void printNotingMessage() {
        System.out.println("낫싱");
    }

    @Override
    public void printAnswerCorrectMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
