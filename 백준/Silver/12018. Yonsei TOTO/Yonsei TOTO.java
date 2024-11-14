import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int n = 0 ; n < N ; n++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());

            int[] cost = new int[P];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < P ; i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }

            if(P < L){
                queue.offer(1);
                continue;
            }

            Arrays.sort(cost);
            queue.offer(cost[P - L]);
        }

        int count = 0;
        while (!queue.isEmpty()){
            int next = queue.poll();
            if(next <= M){
                count++;
                M -= next;
            }
            else break;
        }
        System.out.println(count);
    }
}
