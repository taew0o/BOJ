import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        int N = numbers.length;
        String[] numbersToString = new String[N];
        for(int i = 0 ; i < N ; i++){
            numbersToString[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(numbersToString, (o1, o2) -> Integer.compare(Integer.parseInt(o2 + o1), Integer.parseInt(o1 + o2)));
        String answer = "";
        for(String n : numbersToString){
            answer += n;
        }
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}