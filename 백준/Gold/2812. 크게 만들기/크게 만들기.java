import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int len = N - K;
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            int now = str.charAt(i) - '0';
            if(!stack.isEmpty()){
                while (!stack.isEmpty() && K > 0 && stack.peek() < now){
                    stack.pop();
                    K--;
                }
            }
            stack.push(now);
        }
        while (stack.size() != len){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(int num : stack){
            sb.append(num);
        }
        System.out.println(sb);
    }
}
