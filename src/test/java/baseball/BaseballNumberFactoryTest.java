package baseball;

import baseball.data.BaseballNumber;
import baseball.random.BaseballNumberFactory;
import baseball.random.NsBaseballNumberFactory;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class BaseballNumberFactoryTest {
    @Test
    void 랜덤으로_생성된_숫자가_서로_다른지_테스트(){
        Set<Integer> uniqueNumberSet = new HashSet<>();
        BaseballNumberFactory baseballNumberFactory = new NsBaseballNumberFactory();
        BaseballNumber randomBaseballNumber = baseballNumberFactory.createRandomBaseballNumber();
        List<Integer> numbers = randomBaseballNumber.getNumbers();
        uniqueNumberSet.addAll(numbers);
        assertThat(uniqueNumberSet.size()).isEqualTo(BaseballNumberFactory.NUMBER_SIZE);
    }
}
