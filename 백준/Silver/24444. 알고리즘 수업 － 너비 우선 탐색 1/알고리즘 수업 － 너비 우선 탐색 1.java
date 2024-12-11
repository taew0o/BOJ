import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for(int i = 1 ; i <= N ; i++){
            Collections.sort(graph.get(i));
        }

        int[] result = new int[N + 1];
        result[R] = 1;


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);
        int order = 1;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0 ; i < graph.get(now).size() ; i++){
                int next = graph.get(now).get(i);
                if(result[next] == 0){
                    result[next] = ++order;
                    queue.offer(next);
                }
            }
        }

        for(int i = 1 ; i <= N ; i++){
            sb.append(result[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
