import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static Edge[] graph;
    static int[] parent;
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
    static int find(int a){
        if(a == parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    static class Edge implements Comparable<Edge>{
        int a, b, c;
        public Edge(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }
    public static void kruskal(){
        int cost = 0;
        for(int i = 0 ; i < M ; i++){
            //사이클이 생기지 않는다면 추가.
            if(find(graph[i].a) != find(graph[i].b)){
                union(graph[i].a, graph[i].b);
                cost += graph[i].c;
            }
        }
        System.out.println(cost);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //Union-Find 기본 설정
        parent = new int[N + 1];
        for(int i = 1 ; i <= N ; i++){
            parent[i] = i;
        }

        graph = new Edge[M];
        for(int i = 0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(graph);

        //Kruskal
        kruskal();
    }
}
