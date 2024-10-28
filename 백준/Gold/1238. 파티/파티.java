import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int dst, cost;
        Node(int dst, int cost){
            this.dst = dst;
            this.cost = cost;
        }
    }
    public static int N,M,X;
    public static ArrayList<ArrayList<Node>> graph,rgraph;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int[] go = new int[N + 1];
        int[] back = new int[N + 1];
        graph = new ArrayList<>();
        rgraph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
            rgraph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken())
                    , c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e,c));
            rgraph.get(e).add(new Node(s,c));

        }
        for(int i = 1 ; i <= N ; i++){
            go[i] = Integer.MAX_VALUE;
            back[i] = Integer.MAX_VALUE;
        }
        //X부터 i까지의 최단거리 계산
        PriorityQueue<Node> q = new PriorityQueue<Node>(((o1, o2) -> Integer.compare(o1.cost,o2.cost)))
                , rq = new PriorityQueue<Node>(((o1, o2) -> Integer.compare(o1.cost,o2.cost)));
        q.offer(new Node(X,0));
        rq.offer(new Node(X,0));
        go[X] = 0;
        back[X] = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();
            if(back[cur.dst] < cur.cost){
                continue;
            }
            for(int i = 0 ; i < graph.get(cur.dst).size() ; i++){
                Node next = graph.get(cur.dst).get(i);
                if(back[next.dst] > cur.cost + next.cost){
                    back[next.dst] = cur.cost + next.cost;
                    q.offer(new Node(next.dst, back[next.dst]));
                }
            }
        }
        while (!rq.isEmpty()){
            Node cur = rq.poll();
            if(go[cur.dst] < cur.cost){
                continue;
            }
            for(int i = 0 ; i < rgraph.get(cur.dst).size() ; i++){
                Node next = rgraph.get(cur.dst).get(i);
                if(go[next.dst] > cur.cost + next.cost){
                    go[next.dst] = cur.cost + next.cost;
                    rq.offer(new Node(next.dst, go[next.dst]));
                }
            }
        }
        //X부터 i까지의 최단거리 계산
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N ; i++){
            max = Math.max(max, go[i] + back[i]);
        }
        System.out.println(max);
    }

}
