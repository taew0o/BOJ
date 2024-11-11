import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V,E;
    static int[] parent;
    static Edge[] graph;
    static class Edge implements Comparable<Edge>{
        int u,v,c;
        public Edge(int u, int v, int c){
            this.u = u;
            this.v = v;
            this.c = c;
        }
        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }
    public static void union(int a, int b){
        a = find(a); b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());

        graph = new Edge[E];
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            graph[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        parent = new int[V + 1];
        for(int i = 1 ; i <= V ; i++){
            parent[i] = i;
        }

        Arrays.sort(graph);

        int cost = 0;
        for(int i = 0 ; i < E ; i++){
            //서로 다른 집합에 포함되어 있을 경우에만 선택
            if(find(graph[i].u) == find(graph[i].v)) continue;
            cost += graph[i].c;
            union(graph[i].u, graph[i].v);
        }
        System.out.println(cost);
    }
}
