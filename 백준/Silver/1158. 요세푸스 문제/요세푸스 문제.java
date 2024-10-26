import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[N];
        for(int i = 1 ; i <= N ; i++){
            deque.addLast(i);
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < K - 1 ; j++){
                deque.addLast(deque.pollFirst());
            }
            result[i] = deque.pollFirst();
        }
        sb.append("<");
        for(int i = 0 ; i < N - 1; i++){
            sb.append(result[i]).append(", ");
        }
        sb.append(result[N - 1]);
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
