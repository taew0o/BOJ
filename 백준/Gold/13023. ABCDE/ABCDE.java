import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isVisited;
    public static boolean dfs(int node, int depth){
        if(depth == 4){
            return true;
        }
        for(int i = 0 ; i < graph.get(node).size() ; i++){
            int next = graph.get(node).get(i);
            if(!isVisited[next]){
                isVisited[next] = true;
                if(dfs(next, depth + 1)) return true;
                isVisited[next] = false;
            }
        }
        return false;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1 ; i <= N ; i++){
            isVisited = new boolean[N + 1];
            isVisited[i] = true;
            if(dfs(i, 0)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
