import java.io.*;
import java.util.Arrays;

public class Main {
    public static int N;
    public static int[] graph;
    public static boolean[] visited;
    public static void dfs(int node){
        while (!visited[node]){
            visited[node] = true;
            node = graph[node];
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            N = Integer.parseInt(br.readLine());
            graph = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(i -> i - 1).toArray();
            visited = new boolean[N];
            int cycle = 0;
            for(int i = 0 ; i < N ; i++){
                if(!visited[i]){
                    dfs(i);
                    cycle++;
                }
            }
            sb.append(cycle).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
