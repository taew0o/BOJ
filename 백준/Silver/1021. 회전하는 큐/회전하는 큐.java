import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1 ; i <= N ; i++){
            deque.addLast(i);
        }

        int[] targetList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 0;
        for(int target : targetList){
            int count = 0;
            while (deque.peekFirst() != target){
                deque.addLast(deque.pollFirst());
                count++;
            }
            result += Math.min(count, deque.size() - count);
            deque.pollFirst();
        }

        System.out.println(result);
    }
}
