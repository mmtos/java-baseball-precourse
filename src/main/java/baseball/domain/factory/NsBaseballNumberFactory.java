package baseball.domain.factory;

import baseball.domain.data.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class NsBaseballNumberFactory implements BaseballNumberFactory{

    private String inputExceptionMessage = "서로 다른 " + NUMBER_SIZE+"개의 숫자를 입력해야합니다.";

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

    @Override
    public BaseballNumber createBaseballNumberWithInput(String input) {
        checkInputNumbers(input);
        String[] numbers = input.split("");
        int first = Integer.parseInt(numbers[0]);
        int second = Integer.parseInt(numbers[1]);
        int third = Integer.parseInt(numbers[2]);
        return new BaseballNumber(first,second,third);
    }

    private void checkInputNumbers(String input) {
        checkLength(input);
        checkIsNumber(input);
        checkNumberUnique(input);
    }

    private void checkLength(String input){
        if(input == null || input.length() != NUMBER_SIZE){
            throw new IllegalArgumentException(inputExceptionMessage);
        }
    }

    private void checkIsNumber(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(inputExceptionMessage);
        }
    }

    private void checkNumberUnique(String input){
        Set<Integer> uniqueNumberSet = new HashSet<>();
        String[] numbers = input.split("");
        for(String number : numbers){
            uniqueNumberSet.add(Integer.parseInt(number));
        }
        if(uniqueNumberSet.size() != NUMBER_SIZE){
            throw new IllegalArgumentException(inputExceptionMessage);
        }
    }
}
