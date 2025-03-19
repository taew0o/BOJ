import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static StringBuilder sb;
    static void eulerCircuit(int now){
        for(int next = 0 ; next < N ; next++){
            while (graph[now][next] > 0){
                graph[now][next]--;
                graph[next][now]--;
                eulerCircuit(next);
            }
        }
        sb.append(now + 1).append(" ");
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;//해당 정점에 연결된 간선의 개수
            for(int j = 0 ; j < N ; j++){
                count += graph[i][j] = Integer.parseInt(st.nextToken());
            }
            if(count % 2 != 0){
                System.out.println(-1);
                return;
            }
        }

        sb = new StringBuilder();
        eulerCircuit(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
