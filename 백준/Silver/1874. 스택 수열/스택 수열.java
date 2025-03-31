import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int next = 1;
        while (N --> 0){
            int target = Integer.parseInt(br.readLine());
            if(stack.isEmpty()){
                stack.push(next);
                next++;
                sb.append('+').append('\n');
            }
            while (stack.peek() != target){
                if(stack.peek() > target){
                    System.out.println("NO");
                    return;
                }
                stack.push(next);
                next++;
                sb.append('+').append('\n');
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
