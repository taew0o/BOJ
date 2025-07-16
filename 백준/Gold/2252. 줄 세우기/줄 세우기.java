import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M; //M : 정점의 개수, M : 간선의 개수
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static ArrayList<Integer> topologicalSort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int now = queue.poll();
            result.add(now);
            for(int i = 0 ; i < graph.get(now).size() ; i++){
                int next = graph.get(now).get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return result;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }

        ArrayList<Integer> result = topologicalSort();
        for(int node : result){
            sb.append(node).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
