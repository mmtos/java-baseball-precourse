package baseball.domain.game;

import baseball.domain.data.BaseballHint;
import baseball.domain.data.BaseballNumber;
import baseball.domain.factory.BaseballHintFactory;
import baseball.domain.factory.BaseballNumberFactory;
import baseball.view.BaseballGameView;

public class BaseballGame {
    private static int NEW_GAME = 1;
    private static int GAME_OVER = 2;

    private BaseballGameView view;
    private BaseballNumberFactory baseballNumberFactory;
    private BaseballHintFactory baseballHintFactory;

    private boolean isStageEnd = false;
    private boolean isGameOver = false;

    public BaseballGame(BaseballGameView view, BaseballNumberFactory baseballNumberFactory, BaseballHintFactory baseballHintFactory) {
        this.view = view;
        this.baseballNumberFactory = baseballNumberFactory;
        this.baseballHintFactory = baseballHintFactory;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void start() {
        do{
            stage();
        }while (!isStageEnd);
        askContinueGame();
    }

    public void stage(){
        BaseballNumber inputNumber = takeNumberInputs();
        BaseballHint hint = baseballHintFactory.createBaseballHint(inputNumber);
        printHint(hint);
        printNothingCorrect(hint);
        printAnswerCorrect(hint);
        if(isAnswerCorrect(hint)){
            isStageEnd = true;
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

    private void askContinueGame(){
        try{
            int gameOverFlag =  Integer.parseInt(view.requestContinueOrOverMessage());
            checkGameOverFlag(gameOverFlag);
            handleGameOverFlag(gameOverFlag);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("1과 2 사이 하나만 선택가능합니다.");
        }
    }

    private void checkGameOverFlag(int gameOverFlag){
        if(GAME_OVER != gameOverFlag && NEW_GAME != gameOverFlag){
            throw new IllegalArgumentException("1과 2 사이 하나만 선택가능합니다.");
        }
    }

    private void handleGameOverFlag(int gameOverFlag){
        if(GAME_OVER == gameOverFlag){
            isGameOver = true;
            return;
        }
        isGameOver = false;
    }
}
