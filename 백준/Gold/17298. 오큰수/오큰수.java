import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> left = new Stack<>(), right = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            left.push(Integer.parseInt(st.nextToken()));
        }

        int[] result = new int[N];
        int index = N - 1;
        while (!left.isEmpty()){
            int next = left.pop();
            while (!right.isEmpty() && next >= right.peek()){
                right.pop();
            }
            if(right.isEmpty()){
                result[index--] = -1;
                right.push(next);
            }
            else{
                result[index--] = right.peek();
                right.push(next);
            }
        }
        for(int nge : result){
            sb.append(nge).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
