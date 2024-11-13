import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    static class Edge{
        int A,B,C;
        public Edge(int A, int B, int C){
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        //Union-Find 초기 설정
        parent = new int[N + 1];
        for(int i = 1 ; i <= N ; i++){
            parent[i] = i;
        }

        //그래프 생성
        graph = new Edge[M];
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            graph[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1.C, o2.C));

        //Kruskal
        int cost = 0;
        Queue<Integer> selected = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0 ; i < M ; i++){
            if(find(graph[i].A) != find(graph[i].B)){
                cost += graph[i].C;
                union(graph[i].A, graph[i].B);
                selected.offer(graph[i].C);
            }
        }
        cost -= selected.peek();
        System.out.println(cost);
    }
}
