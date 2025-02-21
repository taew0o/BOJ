import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Edge{
        int end, cost;
        public Edge(int edge, int cost){
            this.end = edge;
            this.cost = cost;
        }
    }
    static int N,M;
    static long MAX = 30_000_000_000L; // 500 * 6000 * 10000
    static ArrayList<ArrayList<Edge>> graph;
    static StringBuilder sb;
    static long[] result;
    public static boolean bellmanFord(){
        //출발지는 1번 도시
        //음수 사이클 발생하면 -1 출력, 경로 없는 도시에 대한 결과는 -1, 아니면 최솟값
        result = new long[N + 1];
        Arrays.fill(result, MAX);
        result[1] = 0;

        boolean update = false;
        for(int i = 1 ; i < N ; i++){
            update = false;
            for(int j = 1 ; j <= N ; j++){
                for(Edge e : graph.get(j)){
                    if(result[j] == MAX) break;
                    if(result[e.end] > result[j] + e.cost){
                        result[e.end] = result[j] + e.cost;
                        update = true;
                    }
                }
            }
            if(!update) break;
        }

        //음수 사이클 확인
        if(update){
            for(int j = 1 ; j <= N ; j++){
                for(Edge e : graph.get(j)){
                    if(result[j] == MAX) break;
                    if(result[e.end] > result[j] + e.cost){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        if(bellmanFord()){
            sb.append(-1);
        }
        else{
            for(int i = 2 ; i <= N ; i++){
                sb.append(result[i] == MAX ? -1 : result[i]).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
