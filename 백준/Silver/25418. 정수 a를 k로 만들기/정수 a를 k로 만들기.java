import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[K + 1];
        queue.offer(A);
        dist[A] = 1;

        while (!queue.isEmpty()){
            int now = queue.poll();
            if(now == K){
                System.out.println(dist[now] - 1);
                return;
            }
            else{
                if(now * 2 <= K && dist[now * 2] == 0){
                    dist[now * 2] = dist[now] + 1;
                    queue.offer(now * 2);
                }
                if(now + 1 <= K && dist[now + 1] == 0){
                    dist[now + 1] = dist[now] + 1;
                    queue.offer(now + 1);
                }
            }
        }
    }
}
