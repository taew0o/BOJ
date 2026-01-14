import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] oldGraph, newGraph;
    static ArrayList<int[]> edges;
    static int sum = 0;
    public static void floydWarshall(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < N ; k++){
                    if(newGraph[j][k] > newGraph[j][i] + newGraph[i][k]){
                        newGraph[j][k] = newGraph[j][i] + newGraph[i][k];
                    }
                }
            }
        }
    }
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        oldGraph = new int[N][N];
        newGraph = new int[N][N];
        edges = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                oldGraph[i][j] = Integer.parseInt(st.nextToken());
                newGraph[i][j] = 100_000;
            }
        }
        for(int i = 0 ; i < N - 1 ; i++){
            for(int j = i + 1 ; j < N ; j++){
                edges.add(new int[]{i, j, oldGraph[i][j]});
            }
        }
        edges.sort(((o1, o2) -> o1[2] - o2[2]));
        for(int[] edge : edges){
            if(oldGraph[edge[0]][edge[1]] == newGraph[edge[0]][edge[1]]) continue;
            if(oldGraph[edge[0]][edge[1]] > newGraph[edge[0]][edge[1]]){
                System.out.println(-1);
                return;
            }
            sum += edge[2];
            newGraph[edge[0]][edge[1]] = edge[2];
            newGraph[edge[1]][edge[0]] = edge[2];
            floydWarshall();
        }
        System.out.println(sum);
    }
}
