import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] visited = new int[100000 + 1];
        Arrays.fill(visited, -1);
        visited[N] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        while (!queue.isEmpty()){
            int now = queue.poll();
            if(now == M){
                System.out.println(visited[now]);
                return;
            }
            int[] dir = {now + 1, now - 1, now + A, now - A, now + B, now - B, now * A, now * B};
            for(int next : dir){
                if(0 <= next && next <= 100000 && visited[next] == -1){
                    visited[next] = visited[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
