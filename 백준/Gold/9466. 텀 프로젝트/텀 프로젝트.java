import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N, count;
    public static int[] graph;
    public static boolean[] visited, finished;
    public static void dfs(int now){
        visited[now] = true;
        int next = graph[now];
        if(!visited[next]){
            dfs(next);
        } else{
            if(!finished[next]){
                count++;
                for(int temp = next; temp != now ; temp =graph[temp]){
                    count++;
                }
            }
        }
        finished[now] = true;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            N = Integer.parseInt(br.readLine()); count = 0;
            graph = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                graph[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1 ; i <= N ; i++){
                if(!finished[i]){
                    dfs(i);
                }
            }
            sb.append(N - count).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
