import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        ArrayList<Integer> result = new ArrayList<>();

        //bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        dist[X] = 0;
        while (!queue.isEmpty()){
            int now = queue.poll();
            if(dist[now] == K){
                result.add(now);
            }
            else if(dist[now] < K){
                for(int i = 0 ; i < graph.get(now).size() ; i++){
                    int next = graph.get(now).get(i);
                    if(dist[next] == -1){
                        dist[next] = dist[now] + 1;
                        queue.offer(next);
                    }
                }
            }
        }

        if(result.size() == 0){
            sb.append(-1);
        }
        else{
            Collections.sort(result);
            for(int num : result){
                sb.append(num).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
