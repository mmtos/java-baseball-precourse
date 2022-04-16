package baseball.domain.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumber {
    private List<Integer> numbers;

    public BaseballNumber(int first, int second, int third) {
        List<Integer> inputNumbers = new ArrayList<>();
        inputNumbers.add(first);
        inputNumbers.add(second);
        inputNumbers.add(third);
        this.numbers = Collections.unmodifiableList(inputNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
