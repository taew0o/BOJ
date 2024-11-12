import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Queue<Long> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            queue.offer(Long.parseLong(st.nextToken()));
        }

        for(int i = 0 ; i < m ; i++){
            long l = queue.poll() + queue.poll();
            queue.offer(l); queue.offer(l);
        }

        long sum = 0;
        while (!queue.isEmpty()){
            sum += queue.poll();
        }
        System.out.println(sum);
    }
}
