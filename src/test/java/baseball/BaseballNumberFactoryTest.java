package baseball;

import baseball.domain.data.BaseballNumber;
import baseball.domain.factory.BaseballNumberFactory;
import baseball.domain.factory.NsBaseballNumberFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class BaseballNumberFactoryTest {

    static BaseballNumberFactory baseballNumberFactory;

    @BeforeAll
    static void createBaseballNumberFactory(){
        baseballNumberFactory = new NsBaseballNumberFactory();
    }

    @Test
    void 랜덤으로_생성된_숫자가_서로_다른지_테스트(){
        Set<Integer> uniqueNumberSet = new HashSet<>();
        BaseballNumber randomBaseballNumber = baseballNumberFactory.createRandomBaseballNumber();
        List<Integer> numbers = randomBaseballNumber.getNumbers();
        uniqueNumberSet.addAll(numbers);
        assertThat(uniqueNumberSet.size()).isEqualTo(BaseballNumberFactory.NUMBER_SIZE);
    }

    @Test
    void 입력값이_숫자가_아닌경우(){
        assertThatIllegalArgumentException().isThrownBy(() ->{
            String input = "abc";
            baseballNumberFactory.createBaseballNumberWithInput(input);
        });
    }

    @Test
    void 입력값의_길이가_잘못된_경우(){
        assertThatIllegalArgumentException().isThrownBy(() ->{
            String input = "1537";
            baseballNumberFactory.createBaseballNumberWithInput(input);
        });
    }

    @Test
    void 입력값의_숫자가_중복된_경우(){
        assertThatIllegalArgumentException().isThrownBy(() ->{
            String input = "355";
            baseballNumberFactory.createBaseballNumberWithInput(input);
        });
    }
}
