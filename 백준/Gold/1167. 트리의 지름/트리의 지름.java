import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int num;
        int dist;
        public Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
    }
    public static int N, node;
    public static ArrayList<Node>[] tree;
    public static boolean[] isVisited;
    public static int max = Integer.MIN_VALUE;
    public static void dfs(int num, int dist){
        if(dist > max){
            node = num;
            max = dist;
        }
        isVisited[num] = true;
        for(Node n : tree[num]){
            if(!isVisited[n.num]){
                dfs(n.num, dist + n.dist);
                isVisited[n.num] = true;
            }
        }
        max = Math.max(max, dist);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        StringTokenizer st;
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            tree[num] = new ArrayList<>();
            int node;
            while ((node = Integer.parseInt(st.nextToken())) != -1){
                tree[num].add(new Node(node, Integer.parseInt(st.nextToken())));
            }
        }
        isVisited = new boolean[N + 1];
        dfs(1, 0);
        isVisited = new boolean[N + 1];
        dfs(node, 0);
        System.out.println(max);
    }
}
