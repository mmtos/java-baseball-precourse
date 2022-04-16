package baseball.random;

import baseball.data.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class NsBaseballNumberFactory implements BaseballNumberFactory{
    @Override
    public BaseballNumber createRandomBaseballNumber() {
        List<Integer> uniqueNumberList = createUniqueNumberList();
        int first = uniqueNumberList.get(0);
        int second = uniqueNumberList.get(1);
        int third = uniqueNumberList.get(2);
        return new BaseballNumber(first,second,third);
    }

    private List<Integer> createUniqueNumberList(){
        Set<Integer> uniqueNumbers = new HashSet<>();
        while(uniqueNumbers.size() < NUMBER_SIZE){
            uniqueNumbers.add(Randoms.pickNumberInRange(1,9));
        }
        List<Integer> uniqueNumberList = new ArrayList<>();
        uniqueNumberList.addAll(uniqueNumbers);
        return uniqueNumberList;
    }

}
