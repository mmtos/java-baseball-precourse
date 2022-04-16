package baseball.domain.data;

public class BaseballHint {
    private int strike;
    private int ball;

    public BaseballHint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballHint that = (BaseballHint) o;
        return strike == that.strike && ball == that.ball;
    }

}
