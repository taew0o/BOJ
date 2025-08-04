import java.util.Arrays;

class Solution {
    public static int toDemical(String num, int system){
        int result = 0;
        int demical = 1;
        for(int i = num.length() - 1 ; i >= 0 ; i--){
            result += (num.charAt(i) - '0') * demical;
            demical *= system;
        }
        return result;
    }
    //10진법 -> N진법
    public static String toOriginSystem(int value, int system){
        String result = "";
        while (value != 0){
            result = String.valueOf(value % system) + result;
            value /= system;
        }
        return result.equals("") ? "0" : result;
    }
    //해당 식의 모든 숫자 중 가장 큰 값 계산
    public static int calMinSystem(String expression){
        String[] info = expression.split(" ");
        String num1 = info[0], num2 = info[2], result = info[4].equals("X") ? "0" : info[4];
        char[] num1Arr = num1.toCharArray(), num2Arr = num2.toCharArray(), resultArr = result.toCharArray();
        Arrays.sort(num1Arr);
        Arrays.sort(num2Arr);
        Arrays.sort(resultArr);
        return Math.max(num1Arr[num1Arr.length - 1] - '0' , Math.max(num2Arr[num2Arr.length - 1] - '0',
                resultArr[resultArr.length - 1] - '0'));
    }
    //두 숫자의 진법 변환 후 계산 반환
    public static int calResult(String expression, int system){
        String[] info = expression.split(" ");
        int num1 = toDemical(info[0], system), num2 = toDemical(info[2], system);
        char oper = info[1].charAt(0);
        switch (oper){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
        }
        return -1;
    }
    //해당 식의 진법 변환 후 계산 값이 정확한지 확인
    public static boolean isRightExpression(String expression, int system){
        String[] info = expression.split(" ");
        int result = toDemical(info[4], system);
        return calResult(expression, system) == result;
    }
    public static String[] solution(String[] expressions){
        boolean[] systemAvailable = new boolean[10]; //해당 진법이 가능한 지
        Arrays.fill(systemAvailable, true);
        int resultLen = expressions.length;
        int minSystem = 2;

        for(String expression : expressions){
            minSystem = Math.max(minSystem, calMinSystem(expression) + 1);
        }

        for (String expression : expressions){
            if(!expression.contains("X")){
                resultLen--;
                for(int i = minSystem ; i < 10 ; i++){
                    if(!isRightExpression(expression, i) && systemAvailable[i]) {
                        systemAvailable[i] = isRightExpression(expression, i);
                    }
                }
            }
        }

        String[] answer = new String[resultLen];
        int index = 0;
        for(String expression : expressions){
            if(expression.contains("X")){
                String result = "";
                int system = -1;
                for(int i = minSystem ; i < 10 ; i++){
                    if(systemAvailable[i]){
                        String value = toOriginSystem(calResult(expression, i), i);
                        if(system == -1){
                            result = value;
                            system = i;
                        }
                        else if(!value.equals(result)){
                            answer[index++] = expression.replace("X" , "?");
                            system = -1;
                            break;
                        }
                    }
                }
                if(system != -1){
                    answer[index++] = expression.replace("X", result);
                }
            }
        }
        return answer;
    }
}