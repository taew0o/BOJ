import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph;
    public static ArrayList<Integer> topologicalSort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            result.add(cur);
            for(int i : graph.get(cur)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int prev =  Integer.parseInt(st.nextToken());
            for(int j = 1 ; j < num ; j++){
                int next = Integer.parseInt(st.nextToken());
                graph.get(prev).add(next);
                indegree[next]++;
                prev = next;
            }
        }
        ArrayList<Integer> result = topologicalSort();
        if(result.size() != N){
            System.out.println(0);
            return;
        }
        for(int i = 0 ; i < N ; i++){
            sb.append(result.get(i)).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
