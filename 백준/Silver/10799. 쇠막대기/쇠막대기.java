import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        char prev = ')', now;
        for (int i = 0 ; i < str.length() ; i++){
            now = str.charAt(i);
            if(now == '('){
                stack.push(now);
            }
            else{
                stack.pop();
                if(prev == '('){
                    result += stack.size();
                }
                else{
                    result++; //하나의 쇠막대기가 끝나면서 새로운 조각이 하나 생김
                }
            }
            prev = now;
        }

        System.out.println(result);
    }
}
