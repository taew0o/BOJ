import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dp;
    static void dfs(int n){
        dp[n] = 1;
        //리프 노드 시 바로 리턴
        int sum = 0;
        for(int next : graph.get(n)){
            //미 방문 노드 시
            if(dp[next] == 0){
                dfs(next);
                sum += dp[next];
            }
        }
        dp[n] += sum;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken()); Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < N - 1 ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v); graph.get(v).add(u);
        }

        dp = new int[N + 1];
        dfs(R);

        for(int i = 0 ; i < Q ; i++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
