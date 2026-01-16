import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[][][] graph;
    public static boolean[][] visited, finished;
    public static int count;
    public static void dfs(int r, int c){
        visited[r][c] = true;
        if(!visited[graph[r][c][0]][graph[r][c][1]]){
            dfs(graph[r][c][0],  graph[r][c][1]);
        } else if(!finished[graph[r][c][0]][graph[r][c][1]]){
            count++;
        }
        finished[r][c] = true;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M][2];
        visited = new boolean[N][M];
        finished = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                switch (str.charAt(j)){
                    case 'U':
                        graph[i][j] = new int[]{i - 1, j};
                        break;
                    case 'D':
                        graph[i][j] = new int[]{i + 1, j};
                        break;
                    case 'L':
                        graph[i][j] = new int[]{i, j - 1};
                        break;
                    case 'R':
                        graph[i][j] = new int[]{i, j + 1};
                        break;
                }
            }
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }
}
