import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, deleted;
    static ArrayList<Integer>[] graph;
    static int count = 0;
    public static void dfs(int num){
        if(graph[num].isEmpty() || (graph[num].size() == 1 && graph[num].get(0) == deleted)){
            count++;
            return;
        }
        for(int next : graph[num]){
            if(next != deleted) dfs(next);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == -1){
                root = i;
            } else{
                graph[p].add(i);
            }
        }
        deleted = Integer.parseInt(br.readLine());
        if(deleted != root) dfs(root);
        System.out.println(count);
    }
}
