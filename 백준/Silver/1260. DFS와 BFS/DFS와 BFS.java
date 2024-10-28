import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n,m,v;
    static int[][] graph;
    static boolean[] is_visited_dfs,is_visited_bfs;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void dfs(int start){
        if(!is_visited_dfs[start]){
            is_visited_dfs[start] = true;
            stringBuilder.append(start + " ");
            for(int i = 1 ; i <= n ; i++){
                if(graph[start][i] == 1){
                    dfs(i);
                }
            }
        }
    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        is_visited_bfs[start] = true;
        while (!queue.isEmpty()){
            int num = queue.poll();
            stringBuilder.append(num + " ");
            for(int i = 1; i <= n ; i++){
                if(!is_visited_bfs[i] && graph[num][i] == 1){
                    queue.offer(i);
                    is_visited_bfs[i] = true;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        v = Integer.parseInt(stringTokenizer.nextToken());
        graph = new int[n + 1][n + 1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                graph[i][j] = 0;
            }
        }
        for(int i = 0 ; i < m ; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            graph[start][end] = graph[end][start] = 1;
        }
        is_visited_dfs = new boolean[n+1];
        is_visited_bfs = new boolean[n+1];
        for(int i = 1 ; i <= n ; i++){
            is_visited_dfs[i] = false;
            is_visited_bfs[i] = false;
        }
        dfs(v);
        stringBuilder.append('\n');
        bfs(v);
        System.out.println(stringBuilder);
    }
}
