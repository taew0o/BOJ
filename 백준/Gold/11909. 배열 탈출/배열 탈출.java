import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr, dp;
    static class Node{
        int r, c, cost;
        public Node(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.offer(new Node(0,0, 0));
        while (!queue.isEmpty()){
            Node now = queue.poll();
            if(dp[now.r][now.c] <= now.cost) continue;
            dp[now.r][now.c] = now.cost;
            if(now.r < N - 1){
                int cost = Math.max(arr[now.r + 1][now.c] - arr[now.r][now.c] + 1, 0);
                queue.offer(new Node(now.r + 1, now.c, dp[now.r][now.c] + cost));
            }
            if(now.c < N - 1){
                int cost = Math.max(arr[now.r][now.c + 1] - arr[now.r][now.c] + 1, 0);
                queue.offer(new Node(now.r, now.c + 1, dp[now.r][now.c] + cost));
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}
