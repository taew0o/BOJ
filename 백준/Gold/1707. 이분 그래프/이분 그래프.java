import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int V,E;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    public static boolean isBipartiteGraph(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= V ; i++){
            if(color[i] == 0){
                color[i] = 1;
                queue.offer(i);
            }
            while (!queue.isEmpty()){
                int now = queue.poll();
                for(int next : graph.get(now)){
                    if(color[now] == color[next]){
                        return false;
                    }
                    if(color[next] == 0){
                        color[next] = -color[now];
                        queue.offer(next);
                    }
                }
            }
        }
        return true;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (K --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            for(int i = 0 ; i <= V ; i++){
                graph.add(new ArrayList<>());
            }
            for(int i = 0 ; i < E ; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            color = new int[V + 1];
            sb.append(isBipartiteGraph() ? "YES" : "NO").append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
