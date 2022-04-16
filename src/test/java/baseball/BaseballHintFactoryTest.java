package baseball;

import baseball.domain.data.BaseballHint;
import baseball.domain.data.BaseballNumber;
import baseball.domain.factory.BaseballHintFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseballHintFactoryTest {

    BaseballHint NOTHING_HINT = new BaseballHint(0,0);
    BaseballHint CORRECT_HINT = new BaseballHint(3,0);

    static BaseballNumber answer = new BaseballNumber(1,6,7);
    static BaseballHintFactory hintFactory = new BaseballHintFactory(answer);

    @Test
    void 낫싱_힌트_생성_테스트(){
        BaseballNumber input = new BaseballNumber(2,3,4);
        BaseballHint hint = hintFactory.createBaseballHint(input);
        assertThat(hint).isEqualTo(NOTHING_HINT);
    }

    @Test
    void 정답_힌트_생성_테스트(){
        BaseballNumber input = new BaseballNumber(1,6,7);
        BaseballHint hint = hintFactory.createBaseballHint(input);
        assertThat(hint).isEqualTo(CORRECT_HINT);
    }

    @Test
    void 볼3_힌트_생성_테스트(){
        BaseballNumber input = new BaseballNumber(6,7,1);
        BaseballHint hint = hintFactory.createBaseballHint(input);
        assertThat(hint).isEqualTo(new BaseballHint(0,3));
    }

    @Test
    void 볼2_스트라이크1_힌트_생성_테스트(){
        BaseballNumber input = new BaseballNumber(6,1,7);
        BaseballHint hint = hintFactory.createBaseballHint(input);
        assertThat(hint).isEqualTo(new BaseballHint(1,2));
    }

    @Test
    void 볼2_힌트_생성_테스트(){
        BaseballNumber input = new BaseballNumber(8,1,6);
        BaseballHint hint = hintFactory.createBaseballHint(input);
        assertThat(hint).isEqualTo(new BaseballHint(0,2));
    }

    @Test
    void 볼1_스트라이크1_힌트_생성_테스트(){
        BaseballNumber input = new BaseballNumber(6,8,7);
        BaseballHint hint = hintFactory.createBaseballHint(input);
        assertThat(hint).isEqualTo(new BaseballHint(1,1));
    }

    @Test
    void 스트라이크2_힌트_생성_테스트(){
        BaseballNumber input = new BaseballNumber(1,6,8);
        BaseballHint hint = hintFactory.createBaseballHint(input);
        assertThat(hint).isEqualTo(new BaseballHint(2,0));
    }

    @Test
    void 볼1_힌트_생성_테스트(){
        BaseballNumber input = new BaseballNumber(3,7,2);
        BaseballHint hint = hintFactory.createBaseballHint(input);
        assertThat(hint).isEqualTo(new BaseballHint(0,1));
    }

    @Test
    void 스트라이크1_힌트_생성_테스트(){
        BaseballNumber input = new BaseballNumber(1,9,8);
        BaseballHint hint = hintFactory.createBaseballHint(input);
        assertThat(hint).isEqualTo(new BaseballHint(1,0));
    }
}
