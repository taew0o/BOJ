import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static boolean[][] graph;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine()); M = Integer.parseInt(br.readLine());
        graph = new boolean[N][N];
        for(int i = 0 ; i < N ; i++){
            graph[i][i] = true;
        }
        for(int i = 0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = true;
        }
        for(int k = 0 ; k < N ; k++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(!graph[i][j] && graph[i][k] && graph[k][j]){
                        graph[i][j] = true;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            int count = 0;
            for(int j = 0 ; j < N ; j++){
                if(!graph[i][j] && !graph[j][i]){
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
